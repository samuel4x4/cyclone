package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.business.Namespace;
import com.ruby.cyclone.configserver.repo.mongo.NamespaceRepository;
import com.ruby.cyclone.configserver.services.NamespaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/namespaces")
public class NamespacesController {

    private final NamespaceRepository namespaceRepository;
    private final NamespaceService namespaceService;

    @Autowired
    public NamespacesController(NamespaceRepository namespaceRepository, NamespaceService namespaceService) {
        this.namespaceRepository = namespaceRepository;
        this.namespaceService = namespaceService;
    }

    @GetMapping
    public List<Namespace> getNamespaces() {
        return namespaceRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Namespace createNamespace(@Valid @RequestBody Namespace namespace) {
        return namespaceRepository.save(namespace);
    }

    @DeleteMapping("/{namespace}/archive")
    public void archive(@PathVariable String namespace) {
        namespaceService.archive(namespace);
    }

}
