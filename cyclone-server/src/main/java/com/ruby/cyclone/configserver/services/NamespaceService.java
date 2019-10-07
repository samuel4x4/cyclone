package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.business.Namespace;
import com.ruby.cyclone.configserver.repo.mongo.NamespaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NamespaceService {

    private NamespaceRepository namespaceRepository;

    @Autowired
    public NamespaceService(NamespaceRepository namespaceRepository) {
        this.namespaceRepository = namespaceRepository;
    }

    public List<String> getNamespaces() {
       return this.namespaceRepository.findAll()
                .stream()
                .map(Namespace::getName)
                .collect(Collectors.toList());
    }

    @Transactional
    public String addNamespace(String namespace) {
        if (namespaceRepository.existsById(namespace)) {
            throw new RuntimeException("Namespace already exists");
            //@cimpoeru TODO make your own exception and make controller advice
        }
        return namespaceRepository.save(Namespace.builder().name(namespace)
                .countries(new ArrayList<>())
                .build()).getName();
    }

    @Transactional
    public void archive(String namespace) {
        //todo make backup collection
        namespaceRepository.deleteById(namespace);
    }



}
