package com.antoine.quizz;

import com.antoine.quizz.apiElements.header.ApiHeader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// ici on gère les pré requis des méthodes HTTP pour les tests
public class TestRequestFactory {

    public static MockHttpServletRequestBuilder factoryGetRequest(String url) {
        return MockMvcRequestBuilders.get(url)
                .header(ApiHeader.HEADER_NAME_VERSION, ApiHeader.STABLE_VERSION)
                .contentType(MediaType.APPLICATION_JSON);

    }
}