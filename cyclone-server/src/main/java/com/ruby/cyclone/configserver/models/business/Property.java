package com.ruby.cyclone.configserver.models.business;


import com.ruby.cyclone.configserver.models.constants.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cyclone")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {

    @Id
    private PropertyId id;
    private PropertyType propertyType;
    private Object value;

}


