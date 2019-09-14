package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.http.request.AddNamespaceRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ruby.cyclone.configserver.controllers.DummyValues.DUMMY_NS;

@RestController
@RequestMapping("cyclone/namespaces")
public class NamespacesController {


    @GetMapping
    public List<String> getNamespaces() {
        return DUMMY_NS;
    }

    @PostMapping
    public List<String> addNamespace(@RequestBody AddNamespaceRequest namespaceRequest) {
        return DUMMY_NS;
    }

}
