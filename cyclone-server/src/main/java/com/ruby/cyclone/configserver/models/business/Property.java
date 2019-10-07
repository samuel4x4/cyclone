package com.ruby.cyclone.configserver.models.business;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
public class Property<T> {

    @Id
    @Indexed
    private PropertyId id;

    @Indexed
    private T value;

    private String file;
}


