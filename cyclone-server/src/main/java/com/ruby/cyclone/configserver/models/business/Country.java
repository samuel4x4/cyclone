package com.ruby.cyclone.configserver.models.business;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "countries")
@Data
@Builder
@EqualsAndHashCode
public class Country {

    @Id
    private String id;

    private String name;

    @DBRef
    private Namespace namespace;

    private List<Property> properties;
}
