package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.api.request.AddNewPropertyRequest;
import com.ruby.cyclone.configserver.models.api.request.UpdatePropertyRequest;
import com.ruby.cyclone.configserver.models.business.Namespace;
import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.repo.mongo.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertiesService {

    private PropertiesRepository propertiesRepository;


    @Autowired
    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }


    public List<Namespace> searchProperties(String namespace, String business, String keyWord) {
        return null;
    }

    public void addProperty(AddNewPropertyRequest propertyRequest) {
//        propertiesRepository.save()

    }

    public void updateProperty(UpdatePropertyRequest propertyRequest) {

    }
}
