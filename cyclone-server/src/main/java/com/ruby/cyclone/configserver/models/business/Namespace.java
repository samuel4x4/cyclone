package com.ruby.cyclone.configserver.models.business;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "namespaces")
@Data
@Builder
@EqualsAndHashCode
public class Namespace {
    @Id
    private String name;

    @DBRef(lazy = true)
    private List<Country> countries;

}
