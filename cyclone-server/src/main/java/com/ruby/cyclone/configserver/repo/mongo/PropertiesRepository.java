package com.ruby.cyclone.configserver.repo.mongo;

import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.models.business.PropertyId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PropertiesRepository extends MongoRepository<Property, PropertyId> {


    @Query("{'_id.namespace': ?0, '_id.country':?1, '_id.key':?2}")
    List<Property> searchByKeyAndLocation(String namespace, String country, String key);


}
