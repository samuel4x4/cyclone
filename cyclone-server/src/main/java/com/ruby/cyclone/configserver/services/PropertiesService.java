package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.repo.mongo.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PropertiesService {

    PropertiesRepository propertiesRepository;

    @Autowired
    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }


    public Map<String, Map<String, Property>> searchProperties(String namespace, String business, String keyWord) {
        return null;
    }
}
