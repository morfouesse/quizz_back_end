package com.antoine.quizz.service.responseEntityApiWithErrorMessageService;

import com.antoine.quizz.constant.ApiConstants;
import com.antoine.quizz.service.surveyApiVersionService.ISurveyApiVersionService;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseEntityApiWithErrorMessageServiceImpl implements IResponseEntityApiWithErrorMessageService {

    private final ISurveyApiVersionService surveyApiVersionService;

    public ResponseEntityApiWithErrorMessageServiceImpl(
            ISurveyApiVersionService surveyApiVersionService) {
        this.surveyApiVersionService = surveyApiVersionService;
    }

    @Override
    public ResponseEntity<String> getStringResponseEntityWithError(int apiVersionClient) {
        // si la version de l'api du client existe et qu'il ne s'agit pas de la version stable
        if (surveyApiVersionService.isContainsRealApiVersion(
                apiVersionClient) && !surveyApiVersionService.isApiVersionStable(
                apiVersionClient)) {
            // on prépare la réponse
            JSONObject json = new JSONObject();
            json.put("status", ApiConstants.BAD_REQUEST);
            json.put("message", ApiConstants.API_VERSION_NOT_STABLE);
            json.put("apiVersion", apiVersionClient);

            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);


            // la version de l'api du client n'existe pas
        } else {

            JSONObject json = new JSONObject();
            json.put("status", ApiConstants.BAD_REQUEST);
            json.put("message", ApiConstants.API_VERSION_DOESNT_EXIST);
            json.put("apiVersion", apiVersionClient);

            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}
