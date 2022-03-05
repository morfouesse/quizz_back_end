package com.antoine.quizz.service;

import com.antoine.quizz.apiElements.header.ApiVersion;
import org.springframework.stereotype.Service;

@Service
public class SurveyApiVersionService {

    ApiVersion apiVersion = new ApiVersion();

    public boolean isContainsRealApiVersion(int apiVersionClient) {
        return apiVersion.listVersion.contains(apiVersionClient);
    }

    public boolean isApiVersionStable(int apiVersionClient) {
        return apiVersionClient == ApiVersion.STABLE_VERSION;
    }
}
