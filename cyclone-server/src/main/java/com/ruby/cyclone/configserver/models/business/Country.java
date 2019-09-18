package com.ruby.cyclone.configserver.models.business;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "countries")
@Data
@Builder
@EqualsAndHashCode
public class Country {

    @Id
    private CountryId id;
    private List<PropertiesFile> files;

}
