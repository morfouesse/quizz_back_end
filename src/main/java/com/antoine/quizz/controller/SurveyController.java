package com.antoine.quizz.controller;


import com.antoine.quizz.dto.SurveyDTO;
import com.antoine.quizz.endpoint.SurveyEndpoint;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/quizz/")
public class SurveyController {

    //sout => print
    private final SurveyService surveyService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
    // ajoute un questionnaire via l'api rest

    @GetMapping(path = SurveyEndpoint.SURVEYS)
    public ResponseEntity<?> getSurveys() {
        try {

            List<Survey> surveyList = surveyService.getSurveys();

            // si tout se passe bien alors on envoie la requete
            return ResponseEntity.ok(surveyList);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }

    }

    @GetMapping(path = SurveyEndpoint.SURVEY)
    public ResponseEntity<?> getSurveyById(@PathVariable("id") String id) {
        try {
            LOGGER.info("SurveyController::: " + id);

            Survey survey = surveyService.getSurveyById(id);

            return ResponseEntity.ok(survey);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
        }
    }


    @PostMapping(path = SurveyEndpoint.CREATE_SURVEY)
    public ResponseEntity<?> addSurvey(@RequestBody SurveyDTO surveyDTO) {

        try {
            LOGGER.info("SurveyController::: " + surveyDTO.getId());
            Survey survey = surveyService.addSurvey(surveyDTO);
            return ResponseEntity.ok(survey);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);

        }

    }

    @PutMapping(path = SurveyEndpoint.UPDATE_SURVEY)
    public ResponseEntity<?> updateSurvey(@RequestBody SurveyDTO surveyDTO) {

        try {
            LOGGER.info("SurveyController::: " + surveyDTO.getId());
            Survey survey = surveyService.updateSurvey(surveyDTO);
            return ResponseEntity.ok(survey);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);

        }

    }

    @DeleteMapping(path = SurveyEndpoint.DELETE_SURVEY)
    public ResponseEntity<?> updateSurvey(@PathVariable("id") String id) {

        try {
            LOGGER.info("SurveyController::: " + id);
            String res = surveyService.deleteSurvey(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);

        }

    }

}
