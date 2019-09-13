package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.AddNamespaceRequest;
import com.ruby.cyclone.configserver.models.AddPlatformRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cyclone/namespaces")
public class NamespacesController {

    private static final List<String> DUMMY_NS = Arrays.asList("mxm", "mgp", "mlm", "tv", "djingo");
    private static final List<String> DUMMY_PLATFORMS = Arrays.asList("test", "qualification", "production");

    @GetMapping
    public List<String> getNamespaces() {
        return DUMMY_NS;
    }

    @PostMapping
    public List<String> addNamespace(@RequestBody AddNamespaceRequest namespaceRequest) {
        return DUMMY_NS;
    }

    @GetMapping("/{namespace}/platforms")
    public List<String> getPlatforms(@PathVariable String namespace) {
        if (DUMMY_NS.contains(namespace.toLowerCase())) {
            return DUMMY_PLATFORMS;
        }
        return Collections.emptyList();
    }

    @PostMapping("/{namespace}/platforms")
    public String addPlatform(@RequestBody AddPlatformRequest platform) {
        return UUID.randomUUID().toString();
    }


    @GetMapping("/{namespaces}/platforms/{platform}/files")
    public List<String> getFiles(@PathVariable String namespace, @PathVariable String platform) {
        if (DUMMY_NS.contains(namespace.toLowerCase()) && DUMMY_NS.contains(platform.toLowerCase())) {
            return Arrays.asList("application.properties", "datastore.properties");
        }
        return Collections.emptyList();
    }

}
