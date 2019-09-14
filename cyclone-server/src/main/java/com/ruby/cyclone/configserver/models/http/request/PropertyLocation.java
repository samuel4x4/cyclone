package com.ruby.cyclone.configserver.models.http.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class PropertyLocation {
    private String namespace;
    private String business;
}
