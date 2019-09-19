package com.ruby.cyclone.configserver.models.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "countries")
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Country {

    @Id
    private String id;
    @Field
    private List<FileName> files = new ArrayList<>();

}
