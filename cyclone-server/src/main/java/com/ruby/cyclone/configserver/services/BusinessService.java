package com.ruby.cyclone.configserver.services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.ruby.cyclone.configserver.controllers.DummyValues.DUMMY_BUSINESSES;
import static com.ruby.cyclone.configserver.controllers.DummyValues.DUMMY_NS;

@Service
public class BusinessService {
    public List<String> getNamespaces(String namespace) {
        if (DUMMY_NS.contains(namespace.toLowerCase())) {
            return DUMMY_BUSINESSES;
        }
        return Collections.emptyList();
    }

    public void archive() {

    }
}
