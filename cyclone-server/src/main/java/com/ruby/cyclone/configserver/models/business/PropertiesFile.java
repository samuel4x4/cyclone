package com.ruby.cyclone.configserver.models.business;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

public class PropertiesFile {

    @Id
    private String name;

    private List<Property> properties;












    public PropertiesFile() {
    }

    public PropertiesFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertiesFile that = (PropertiesFile) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PropertiesFile{" +
                "name='" + name;
    }
}
