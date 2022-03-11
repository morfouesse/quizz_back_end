package com.antoine.quizz;

import com.antoine.quizz.apiElements.header.ApiVersion;
import com.antoine.quizz.apiElementsTest.MethodsHttp;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// ici on gère les pré requis des méthodes HTTP pour les tests
public class TestRequestFactory {


    public static MockHttpServletRequestBuilder factoryGetRequest(
            @NonNull String url,
            @NonNull MethodsHttp methodsHttp) {

        switch (methodsHttp) {
            case get -> {
                return MockMvcRequestBuilders.get(
                                url)
                        .header(ApiVersion.HEADER_NAME_VERSION,
                                ApiVersion.STABLE_VERSION)
                        .contentType(
                                MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON);

            }
            case post -> {
                return MockMvcRequestBuilders.post(
                                url)
                        .header(ApiVersion.HEADER_NAME_VERSION,
                                ApiVersion.STABLE_VERSION)
                        .contentType(
                                MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON);
            }
        }

        return null;
    }


}