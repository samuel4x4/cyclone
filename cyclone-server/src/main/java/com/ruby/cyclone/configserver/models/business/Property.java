package com.ruby.cyclone.configserver.models.business;


import io.swagger.models.properties.PropertyBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
public class Property<T> {

    @Id
    @Indexed
    private PropertyId key;

    @Indexed
    private T value;


    private String file;

}


