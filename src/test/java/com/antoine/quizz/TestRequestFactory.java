package com.antoine.quizz;

import com.antoine.quizz.apiElements.header.ApiVersion;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// ici on gère les pré requis des méthodes HTTP pour les tests
public class TestRequestFactory {

    public static MockHttpServletRequestBuilder factoryGetRequest(String url) {
        return MockMvcRequestBuilders.get(url)
                .header(ApiVersion.HEADER_NAME_VERSION, ApiVersion.STABLE_VERSION)
                .contentType(MediaType.APPLICATION_JSON);

    }
}