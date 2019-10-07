package com.ruby.cyclone.configserver.repo.mongo;

import com.ruby.cyclone.configserver.models.business.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TenantRepository extends MongoRepository<Tenant, String> {
}
