package com.ruby.cyclone.configserver.models.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "namespaces")
@Data
@Builder
@AllArgsConstructor

public class Namespace {

    @Id
    private String id;

    @NotBlank
    @Indexed(unique = true)
    private String name;

    @DBRef
    private Tenant tenant;

    private List<Country> countries = new ArrayList<>();
}
