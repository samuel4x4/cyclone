package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.http.request.AddPlatformRequest;
import com.ruby.cyclone.configserver.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cyclone/namespaces/{namespace}/businesses")
public class BusinessController {

    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping()
    public List<String> getPlatforms(@PathVariable String namespace) {
        return businessService.getNamespaces(namespace);
    }


    @PostMapping()
    public String addPlatform(@RequestBody AddPlatformRequest platform) {
        return UUID.randomUUID().toString();
    }

    @DeleteMapping("/{business}/archive")
    public void archive() {
        this.businessService.archive();
    }

}
