package com.ruby.cyclone.configserver.services;

import com.ruby.cyclone.configserver.models.business.Country;
import com.ruby.cyclone.configserver.models.business.CountryId;
import com.ruby.cyclone.configserver.repo.mongo.CountryRepository;
import com.ruby.cyclone.configserver.repo.mongo.NamespaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private CountryRepository countryRepository;
    private NamespaceRepository namespaceRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository, NamespaceRepository namespaceRepository) {
        this.countryRepository = countryRepository;
        this.namespaceRepository = namespaceRepository;
    }

    public List<String> getBusinesses(String namespace) {
        return countryRepository.findAllByNamespace(namespace)
                .stream()
                .map(country -> country.getId().getCountryId())
                .collect(Collectors.toList());
    }


    public void archive(String namespace, String country) {
        CountryId id = CountryId.builder().namespaceId(namespace).countryId(country).build();
        this.countryRepository.deleteById(id);
    }

    public String addCountry(String namespace, String country) {
        if (!namespaceRepository.existsById(namespace)) {
            //todo manage exceptions
            throw new RuntimeException("404 Namespace not found");
        }
        CountryId id = CountryId.builder().namespaceId(namespace).countryId(country).build();
        Country countryDao = Country.builder().id(id).build();
        Country save = this.countryRepository.save(countryDao);
        return save.getId().getCountryId();
    }

}
