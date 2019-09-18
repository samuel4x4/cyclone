package com.ruby.cyclone.configserver.models.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class CountryId {

    private String namespaceId;
    private String countryId;
}
