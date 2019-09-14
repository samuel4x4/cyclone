package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.services.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/cyclone/properties")
public class PropertiesController {


    PropertiesService propertiesService;


    @Autowired
    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Map<String, Property>> searchProperties(@RequestParam String namespace,
                                                               @RequestParam String business,
                                                               @RequestParam String keyWord) {
        return propertiesService.searchProperties(namespace, business, keyWord);
    }


}
