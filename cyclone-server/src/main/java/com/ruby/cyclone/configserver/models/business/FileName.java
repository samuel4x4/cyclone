package com.ruby.cyclone.configserver.models.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Document
public class FileName {
    @Id
    String name;

    private String description;
}
