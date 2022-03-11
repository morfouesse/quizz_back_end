package com.antoine.quizz.service.surveyApiVersionService;

public interface ISurveyApiVersionService {
    public boolean isContainsRealApiVersion(int apiVersionClient);

    public boolean isApiVersionStable(int apiVersionClient);
}
