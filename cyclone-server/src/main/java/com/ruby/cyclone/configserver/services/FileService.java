package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.business.*;
import com.ruby.cyclone.configserver.models.constants.FileFormat;
import com.ruby.cyclone.configserver.repo.mongo.NamespaceRepository;
import com.ruby.cyclone.configserver.repo.mongo.PropertiesRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class FileService {

    private NamespaceRepository namespaceRepository;

    private PropertiesRepository propertiesRepository;

    @Autowired
    public FileService(NamespaceRepository namespaceRepository, PropertiesRepository propertiesRepository) {
        this.namespaceRepository = namespaceRepository;
        this.propertiesRepository = propertiesRepository;
    }

    public List<String> getFiles(String namespaceId, String countryId) {

        Optional<Namespace> namespaceDao = this.namespaceRepository.findById(namespaceId);
        return namespaceDao.map(ns -> ns.getCountries())
                .flatMap(countries -> countries.stream().filter(c -> c.equals(countryId)).findFirst())
                .map(Country::getFiles)
                .orElseThrow(() -> new RuntimeException())
                .stream()
                .map(FileName::getName).collect(Collectors.toList());

    }

    public String importProperties(String namespace, String country, FileFormat fileFormat, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();

        System.out.println(originalFilename);
        InputStream is = file.getInputStream();
        Properties properties = new Properties();
        properties.load(is);
        List<Property> appProperties = new ArrayList<>();
        properties.forEach((k, v) -> {
            PropertyId id = PropertyId.builder().key(k.toString())
                    .namespace(namespace)
                    .country(country)
                    .file(file.getOriginalFilename())
                    .build();
            Property property = new Property();
            property.setId(id);
            property.setValue(v);
            appProperties.add(property);
        });
        propertiesRepository.saveAll(appProperties);
        return originalFilename;


    }

    public List<Property> getPropertiesFromFile(String namespace, String country, String file) {
        return null;
    }

    public Resource exportFile(String namespace, String country, String filename) throws IOException {

        File tempDirectory = new File("./export");
        tempDirectory.mkdir();
        File tempFile = new File("./export/" + filename);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            Properties properties = readPropertiesFromDb(namespace, country, filename);
            properties.store(fos, "");
        }
        try (FileInputStream fis = new FileInputStream(tempFile)) {

            Resource resource = new ByteArrayResource(IOUtils.toByteArray(fis));
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found " + filename);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + filename, ex);
        } finally {
            tempFile.delete();
            tempDirectory.delete();
        }
    }

    private Properties readPropertiesFromDb(String namespace, String country, String filename) {
        List<Property> appProperties = propertiesRepository.searchByKeyAndLocation(namespace, country, filename, "");

        Properties properties = new Properties();
        appProperties.forEach(p -> {
            properties.put(p.getId().getKey(), p.getValue());
        });
        return properties;
    }

    public String addFile(String namespaceId, String countryId, String file) {
        Optional<Namespace> namespace = this.namespaceRepository.findById(namespaceId);
        return namespace.flatMap(ns -> {
            List<Country> countries = ns.getCountries();
            return countries.stream().filter(c -> c.getId().equals(countryId)).findFirst()
                    .flatMap(c -> {
                        List<FileName> files = c.getFiles();
                        if (files == null) {
                            files = new ArrayList<>();
                        }
                        files.add(new FileName(file));
                        c.setFiles(files);
                        ns.setCountries(countries);
                        namespaceRepository.save(ns);

                        return Optional.of(file);
                    });
        }).orElseThrow(() -> new RuntimeException());
    }
}
