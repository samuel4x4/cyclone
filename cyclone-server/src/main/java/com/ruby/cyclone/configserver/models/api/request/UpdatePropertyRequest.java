package com.ruby.cyclone.configserver.models.api.request;

import java.util.Map;

public class UpdatePropertyRequest {
    private String key;
    private Map<PropertyLocation, Object> valuesByLocation;

}

