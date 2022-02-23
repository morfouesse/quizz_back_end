package com.antoine.quizz.apiElements.endpoint;

import org.springframework.stereotype.Component;

@Component
public class SurveyEndpoint {
    public static final String SURVEYS = "/surveys";
    public static final String SURVEY = "/survey/{id}";
    public static final String CREATE_SURVEY = "/survey";
    public static final String UPDATE_SURVEY = "/survey";
    public static final String DELETE_SURVEY = "/survey/{id}";

}
