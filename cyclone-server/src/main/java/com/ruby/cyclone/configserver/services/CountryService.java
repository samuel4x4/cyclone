package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.business.Country;
import com.ruby.cyclone.configserver.models.business.FileName;
import com.ruby.cyclone.configserver.models.business.Namespace;
import com.ruby.cyclone.configserver.repo.mongo.NamespaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private NamespaceRepository namespaceRepository;

    @Autowired
    public CountryService(NamespaceRepository namespaceRepository) {
        this.namespaceRepository = namespaceRepository;
    }

    public List<Country> getBusinesses(String namespace) {
        return namespaceRepository.findById(namespace)
                .map(Namespace::getCountries)
                .orElseThrow(() -> new RuntimeException())
                .stream()
                .collect(Collectors.toList());
    }


    public void archive(String namespace, String country) {
        Optional<Namespace> ns = this.namespaceRepository.findById(namespace);
        ns.map(nsDao -> {
            List<Country> countries = nsDao.getCountries();
            countries.remove(country);
            nsDao.setCountries(countries);
            namespaceRepository.save(nsDao);
            return true;
        }).orElseThrow(() -> new RuntimeException());
    }

    public String addCountry(String namespace, Country country) {
        Optional<Namespace> ns = this.namespaceRepository.findById(namespace);
        return ns.map(nsDao -> {
            List<Country> countries = nsDao.getCountries();
            if (countries == null) {
                countries = new ArrayList<>();
            }
            countries.add(country);
            nsDao.setCountries(countries);
            namespaceRepository.save(nsDao);
            return country.getId();
        }).orElseThrow(() -> new RuntimeException());
    }


}
