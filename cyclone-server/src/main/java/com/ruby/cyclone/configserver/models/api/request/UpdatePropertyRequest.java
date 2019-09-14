package com.ruby.cyclone.configserver.models.api.request;

import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UpdatePropertyRequest {
    private String key;
    private Map<PropertyLocation, Object> valuesByLocation;

}

