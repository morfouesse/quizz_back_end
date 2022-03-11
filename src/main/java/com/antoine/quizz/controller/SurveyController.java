package com.antoine.quizz.controller;


import com.antoine.quizz.apiElements.endpoint.SurveyEndpoint;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.service.loggerService.LoggerServiceImpl;
import com.antoine.quizz.service.responseEntityApiWithErrorMessageService.ResponseEntityApiWithErrorMessageServiceImpl;
import com.antoine.quizz.service.surveyApiVersionService.SurveyApiVersionServiceImpl;
import com.antoine.quizz.service.surveyService.SurveyServiceImpl;
import lombok.extern.slf4j.Slf4j;
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


    // https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api

    // https://softwareengineering.stackexchange.com/questions/211275/should-an-http-api-always-return-a-body
    //sout => print
    private final SurveyServiceImpl surveyService;
    private final SurveyApiVersionServiceImpl surveyApiVersionService;
    private final ResponseEntityApiWithErrorMessageServiceImpl responseEntityWithErrorMessageService;
    private final LoggerServiceImpl loggerService;


    public SurveyController(SurveyServiceImpl surveyService,
            SurveyApiVersionServiceImpl surveyApiVersionService,
            ResponseEntityApiWithErrorMessageServiceImpl responseEntityWithErrorMessageService,
            LoggerServiceImpl loggerService) {
        this.surveyService = surveyService;
        this.surveyApiVersionService = surveyApiVersionService;
        this.responseEntityWithErrorMessageService = responseEntityWithErrorMessageService;
        this.loggerService = loggerService;
    }

    @GetMapping(path = SurveyEndpoint.SURVEYS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSurveys(
            @RequestHeader(value = "X-API-VERSION") int apiVersionClient) {

        loggerService.loggerInfo("SurveyController:: apiVersionClient : " + apiVersionClient);

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
            return responseEntityWithErrorMessageService.getStringResponseEntityWithError(
                    apiVersionClient);
        }
    }


    @GetMapping(path = SurveyEndpoint.SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSurveyById(@PathVariable("id") String id,
            @RequestHeader(value = "X-API-VERSION") int apiVersionClient) {

        loggerService.loggerInfo("SurveyController:: apiVersionClient : " + apiVersionClient);

        if (surveyApiVersionService.isContainsRealApiVersion(
                apiVersionClient) && surveyApiVersionService.isApiVersionStable(apiVersionClient)) {

            loggerService.loggerInfo("SurveyController::: id : " + id);

            try {
                Survey survey = surveyService.getSurveyById(id);

                return ResponseEntity.ok(survey);
            } catch (RuntimeException e) {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
        } else
            return responseEntityWithErrorMessageService.getStringResponseEntityWithError(
                    apiVersionClient);
    }


    @PostMapping(path = SurveyEndpoint.CREATE_SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSurvey(@RequestBody Survey surveyClient,
            @RequestHeader(value = "X-API-VERSION") int apiVersionClient) {

        loggerService.loggerInfo("SurveyController:: apiVersionClient : " + apiVersionClient);

        if (surveyApiVersionService.isContainsRealApiVersion(
                apiVersionClient) && surveyApiVersionService.isApiVersionStable(apiVersionClient)) {

            loggerService.loggerInfo(
                    "SurveyController::: " + "surveyCLient : " + surveyClient.getId());

            try {

                surveyService.addSurvey(surveyClient);

                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
        } else
            return responseEntityWithErrorMessageService.getStringResponseEntityWithError(
                    apiVersionClient);
    }

    @PutMapping(path = SurveyEndpoint.UPDATE_SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSurvey(@RequestBody Survey surveyClient,
            @RequestHeader(value = "X-API-VERSION") int apiVersionClient) {


        loggerService.loggerInfo("SurveyController:: apiVersionClient : " + apiVersionClient);

        if (surveyApiVersionService.isContainsRealApiVersion(
                apiVersionClient) && surveyApiVersionService.isApiVersionStable(apiVersionClient)) {

            loggerService.loggerInfo(
                    "SurveyController::: " + "surveyClient : " + surveyClient.getId());

            try {

                surveyService.updateSurvey(surveyClient);

                return new ResponseEntity<>(HttpStatus.OK);
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
        } else
            return responseEntityWithErrorMessageService.getStringResponseEntityWithError(
                    apiVersionClient);

    }

    @DeleteMapping(path = SurveyEndpoint.DELETE_SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSurvey(@PathVariable("id") String id,
            @RequestHeader(value = "X-API-VERSION") int apiVersionClient) {


        loggerService.loggerInfo("SurveyController:: apiVersionClient : " + apiVersionClient);

        if (surveyApiVersionService.isContainsRealApiVersion(
                apiVersionClient) && surveyApiVersionService.isApiVersionStable(apiVersionClient)) {
            loggerService.loggerInfo("SurveyController::: " + " id : " + id);

            try {
                loggerService.loggerInfo("SurveyController::: " + id);

                surveyService.deleteSurvey(id);

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
        } else
            return responseEntityWithErrorMessageService.getStringResponseEntityWithError(
                    apiVersionClient);
    }

}
