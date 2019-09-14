package com.ruby.cyclone.configserver.models.api.request;


import com.ruby.cyclone.configserver.models.constants.PropertyType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AddNewPropertyRequest {
    private String key;
    private String defaultValue;
    private String file;
    private PropertyType type;
    private String description;
}
