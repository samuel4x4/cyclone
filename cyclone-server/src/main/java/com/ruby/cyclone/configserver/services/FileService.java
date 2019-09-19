package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.business.Country;
import com.ruby.cyclone.configserver.models.business.FileName;
import com.ruby.cyclone.configserver.models.business.Namespace;
import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.models.constants.FileFormat;
import com.ruby.cyclone.configserver.repo.mongo.NamespaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileService {

    private NamespaceRepository namespaceRepository;

    @Autowired
    public FileService(NamespaceRepository namespaceRepository) {
        this.namespaceRepository = namespaceRepository;
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

    public String importProperties(String namespace, String country, FileFormat fileFormat, MultipartFile file) {
        return UUID.randomUUID().toString();
    }

    public List<Property> getPropertiesFromFile(String namespace, String country, String file) {
        return null;
    }

    public void exportFile(String namespace, String country, String filename) {
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
