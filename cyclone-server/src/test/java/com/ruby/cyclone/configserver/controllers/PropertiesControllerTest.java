package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.api.response.SearchPropertiesResponse;
import com.ruby.cyclone.configserver.models.business.Country;
import com.ruby.cyclone.configserver.models.business.Namespace;
import com.ruby.cyclone.configserver.models.business.Property;
import com.ruby.cyclone.configserver.models.business.PropertyId;
import com.ruby.cyclone.configserver.services.PropertiesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(PropertiesController.class)
public class PropertiesControllerTest {

    public static final String COUNTRY = "ORO";
    public static final String NAMESPACE = "test";
    public static final String KEY_WORD = "user.name";


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertiesService propertiesService;

    @Test
    public void test() throws Exception {
        Property<String> stringProperty = new Property<>();
        PropertyId id = PropertyId.builder().namespace(NAMESPACE).business(COUNTRY).key("user.name").build();
        stringProperty.setId(id);
        stringProperty.setValue("ruby");
        SearchPropertiesResponse builpropertiesResponse = SearchPropertiesResponse.builder()
                .namespaces(Arrays.asList(Namespace.builder()
                        .name(NAMESPACE)
                        .countries(Arrays.asList(Country.builder().id(COUNTRY).name(COUNTRY)

                                .properties(Arrays.asList(stringProperty))
                                .build()))
                        .build()))
                .build();

        Mockito.when(propertiesService.searchProperties(NAMESPACE, COUNTRY, KEY_WORD))
                .thenReturn(builpropertiesResponse);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/properties/search")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("namespace", NAMESPACE)
                .param("country", COUNTRY)
                .param("key", KEY_WORD)
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

}
