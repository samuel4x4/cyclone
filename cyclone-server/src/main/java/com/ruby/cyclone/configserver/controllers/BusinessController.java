package com.ruby.cyclone.configserver.controllers;

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
    public List<String> getBusinesses(@PathVariable String namespace) {
        return businessService.getBusinesses(namespace);
    }


    @PostMapping()
    public String addBusiness(@RequestBody String business) {
        return UUID.randomUUID().toString();
    }

    @DeleteMapping("/{business}/archive")
    public void archive() {
        this.businessService.archive();
    }

}
