package com.antoine.quizz.service.responseEntityApiWithErrorMessageService;

import org.springframework.http.ResponseEntity;

public interface IResponseEntityApiWithErrorMessageService {
    public ResponseEntity<String> getStringResponseEntityWithError(int apiVersionClient);
}
