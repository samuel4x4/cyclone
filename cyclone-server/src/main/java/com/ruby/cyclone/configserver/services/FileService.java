package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.business.Country;
import com.ruby.cyclone.configserver.models.business.CountryId;
import com.ruby.cyclone.configserver.models.business.PropertiesFile;
import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.models.constants.FileFormat;
import com.ruby.cyclone.configserver.repo.mongo.CountryRepository;
import com.ruby.cyclone.configserver.repo.mongo.NamespaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
//TODO replace with country logic this dummy methods
public class FileService {

    private CountryRepository countryRepository;
    private NamespaceRepository namespaceRepository;

    public List<String> getFiles(String namespace, String country) {
        return countryRepository.findById(new CountryId(namespace, country))
                .map(countryDao -> countryDao.getFiles().stream().map(f -> f.getName()).collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("No such business or country")); //todo excepion management
    }

    public String importProperties(String namespace, String country, FileFormat fileFormat, MultipartFile file) {
        return UUID.randomUUID().toString();
    }

    public List<Property> getPropertiesFromFile(String namespace, String country, String file) {
        return null;
    }

    public void exportFile(String namespace, String country, String filename) {

    }

    public String addFile(String namespace, String country, String file) {
        CountryId countryId = new CountryId(namespace, country);
        Optional<Country> byId = this.countryRepository.findById(countryId);
        return byId.map(countryDao -> {
            countryDao.getFiles().add(new PropertiesFile(file));
            this.countryRepository.save(countryDao);
            return file;
        }).orElseThrow(() -> new RuntimeException()); // todo exception mangement
    }
}
