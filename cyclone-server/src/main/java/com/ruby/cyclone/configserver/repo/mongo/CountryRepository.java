package com.ruby.cyclone.configserver.repo.mongo;

import com.ruby.cyclone.configserver.models.business.Country;
import com.ruby.cyclone.configserver.models.business.CountryId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CountryRepository extends MongoRepository<Country, CountryId> {

    @Query("{'_id.namespaceId':?0})")
    List<Country> findAllByNamespace(String namespace);
}
