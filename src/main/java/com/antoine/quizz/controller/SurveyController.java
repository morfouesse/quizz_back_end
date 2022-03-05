package com.antoine.quizz.controller;


import com.antoine.quizz.apiElements.endpoint.SurveyEndpoint;
import com.antoine.quizz.dto.SurveyDTO;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.service.LoggerService;
import com.antoine.quizz.service.ResponseEntityWithErrorMessageService;
import com.antoine.quizz.service.SurveyApiVersionService;
import com.antoine.quizz.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/quizz/")
public class SurveyController {

    //https://www.gekko.fr/blog/les-bonnes-pratiques-a-suivre-pour-developper-des-apis-rest

    //sout => print
    @Autowired
    SurveyService surveyService;
    @Autowired
    SurveyApiVersionService surveyApiVersionService;
    @Autowired
    ResponseEntityWithErrorMessageService responseEntityWithErrorMessageService;
    @Autowired
    LoggerService logger;


    // ajoute un questionnaire via l'api rest

    @GetMapping(path = SurveyEndpoint.SURVEYS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSurveys(@RequestHeader(value = "X-API-VERSION") int apiVersionClient) {

        logger.loggerInfo("SurveyController:: apiVersionClient : " + apiVersionClient);

        if (surveyApiVersionService.isContainsRealApiVersion(
                apiVersionClient) && surveyApiVersionService.isApiVersionStable(apiVersionClient)) {

            // si la version de l'api du client existe et qu'il s'agit de la version stable
            try {

                List<Survey> surveyList = surveyService.getSurveys();

                // si tout se passe bien alors on envoie la requete
                return ResponseEntity.ok(surveyList);
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
        } else {
            return responseEntityWithErrorMessageService.getStringResponseEntityWithError(apiVersionClient);
        }
    }


    @GetMapping(path = SurveyEndpoint.SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSurveyById(@PathVariable("id") String id, @RequestHeader(value = "X-API-VERSION") int apiVersionClient) {

        logger.loggerInfo("SurveyController:: apiVersionClient : " + apiVersionClient);

        if (surveyApiVersionService.isContainsRealApiVersion(
                apiVersionClient) && surveyApiVersionService.isApiVersionStable(apiVersionClient)) {

            logger.loggerInfo("SurveyController::: id : " + id);

            try {
                Survey survey = surveyService.getSurveyById(id);

                return ResponseEntity.ok(survey);
            } catch (RuntimeException e) {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
        } else
            return responseEntityWithErrorMessageService.getStringResponseEntityWithError(apiVersionClient);
    }

    //TODO: refactor other method

    @PostMapping(path = SurveyEndpoint.CREATE_SURVEY)
    public ResponseEntity<?> addSurvey(@RequestBody SurveyDTO surveyDTO) {

        try {
            logger.loggerInfo("SurveyController::: " + surveyDTO.getId());
            Survey survey = surveyService.addSurvey(surveyDTO);
            return ResponseEntity.ok(survey);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);

        }

    }

    @PutMapping(path = SurveyEndpoint.UPDATE_SURVEY)
    public ResponseEntity<?> updateSurvey(@RequestBody SurveyDTO surveyDTO) {

        try {
            logger.loggerInfo("SurveyController::: " + surveyDTO.getId());
            Survey survey = surveyService.updateSurvey(surveyDTO);
            return ResponseEntity.ok(survey);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);

        }

    }

    @DeleteMapping(path = SurveyEndpoint.DELETE_SURVEY)
    public ResponseEntity<?> updateSurvey(@PathVariable("id") String id) {

        try {
            logger.loggerInfo("SurveyController::: " + id);
            String res = surveyService.deleteSurvey(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);

        }

    }

}
