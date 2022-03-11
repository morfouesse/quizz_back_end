package com.antoine.quizz.service.surveyApiVersionService;

import com.antoine.quizz.apiElements.header.ApiVersion;
import org.springframework.stereotype.Service;

@Service
public class SurveyApiVersionServiceImpl implements ISurveyApiVersionService {

    private final ApiVersion apiVersion;

    public SurveyApiVersionServiceImpl(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public boolean isContainsRealApiVersion(int apiVersionClient) {
        return apiVersion.listVersion.contains(apiVersionClient);
    }

    @Override
    public boolean isApiVersionStable(int apiVersionClient) {
        return apiVersionClient == ApiVersion.STABLE_VERSION;
    }
}
