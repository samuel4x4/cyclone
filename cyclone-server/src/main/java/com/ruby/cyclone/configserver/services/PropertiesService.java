package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.api.request.AddNewPropertyRequest;
import com.ruby.cyclone.configserver.models.api.request.UpdatePropertyRequest;
import com.ruby.cyclone.configserver.models.api.response.SearchPropertiesResponse;
import com.ruby.cyclone.configserver.repo.mongo.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {

    PropertiesRepository propertiesRepository;

    @Autowired
    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }


    public SearchPropertiesResponse searchProperties(String namespace, String business, String keyWord) {
        return null;
    }

    public void addProperty(AddNewPropertyRequest propertyRequest) {

    }

    public void updateProperty(UpdatePropertyRequest propertyRequest) {

    }
}
