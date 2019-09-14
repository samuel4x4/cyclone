package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.http.request.AddPlatformRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.ruby.cyclone.configserver.controllers.DummyValues.DUMMY_BUSINESSES;
import static com.ruby.cyclone.configserver.controllers.DummyValues.DUMMY_NS;

@RestController
@RequestMapping("cyclone/namespaces/{namespace}")
public class BusinessController {


    @GetMapping("/businesses")
    public List<String> getPlatforms(@PathVariable String namespace) {
        if (DUMMY_NS.contains(namespace.toLowerCase())) {
            return DUMMY_BUSINESSES;
        }
        return Collections.emptyList();
    }


    @PostMapping("/businesses")
    public String addPlatform(@RequestBody AddPlatformRequest platform) {
        return UUID.randomUUID().toString();
    }

}
