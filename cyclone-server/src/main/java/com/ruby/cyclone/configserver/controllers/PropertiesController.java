package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.api.request.AddNewPropertyRequest;
import com.ruby.cyclone.configserver.models.api.request.UpdatePropertyRequest;
import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.services.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("/cyclone/properties")
public class PropertiesController {


    private PropertiesService propertiesService;


    @Autowired
    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Map<String, Property>> searchProperties(@RequestParam(defaultValue = "all") String namespace,
                                                               @RequestParam(defaultValue = "all") String business,
                                                               @RequestParam String keyWord) {
        return propertiesService.searchProperties(namespace, business, keyWord);
    }


    @PostMapping
    public void addNewProperty(@RequestBody AddNewPropertyRequest propertyRequest) {
        propertiesService.addProperty(propertyRequest);
    }

    @PutMapping
    public void changeProperty(@RequestBody UpdatePropertyRequest propertyRequest) {
        propertiesService.updateProperty(propertyRequest);
    }
}
