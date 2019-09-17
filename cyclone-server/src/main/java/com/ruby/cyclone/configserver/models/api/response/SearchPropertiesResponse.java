package com.ruby.cyclone.configserver.models.api.response;

import com.ruby.cyclone.configserver.models.business.Namespace;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class SearchPropertiesResponse {

    private List<Namespace> namespaces;

}
