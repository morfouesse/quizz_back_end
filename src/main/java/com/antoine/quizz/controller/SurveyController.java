package com.antoine.quizz.controller;


import com.antoine.quizz.apiElements.endpoint.SurveyEndpoint;
import com.antoine.quizz.apiElements.header.ApiHeader;
import com.antoine.quizz.constant.ApiConstants;
import com.antoine.quizz.dto.SurveyDTO;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final SurveyService surveyService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
        
    }
    // ajoute un questionnaire via l'api rest

    @GetMapping(path = SurveyEndpoint.SURVEYS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSurveys(@RequestHeader(value = "X-API-VERSION") int apiVersionClient) {

        // on pourra accéder à la liste des versions qui existe.
        ApiHeader apiHeader = new ApiHeader();
        // si la version de l'api du client existe et qu'il ne s'agit pas de la version stable
        if (apiHeader.listVersion.contains(apiVersionClient) && apiVersionClient != ApiHeader.STABLE_VERSION) {
            // on prépare la réponse
            JSONObject json = new JSONObject();
            json.put("status", ApiConstants.BAD_REQUEST);
            json.put("message", ApiConstants.API_VERSION_NOT_STABLE);
            json.put("apiVersion", apiVersionClient);

            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
            // si la version de l'api du client existe et qu'il s'agit de la version stable
        } else if (apiHeader.listVersion.contains(apiVersionClient) && apiVersionClient == ApiHeader.STABLE_VERSION) {
            try {

                List<Survey> surveyList = surveyService.getSurveys();

                // si tout se passe bien alors on envoie la requete
                return ResponseEntity.ok(surveyList);
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
            // la version de l'api du client n'existe pas
        } else {

            JSONObject json = new JSONObject();
            json.put("status", ApiConstants.BAD_REQUEST);
            json.put("message", ApiConstants.API_VERSION_DOESNT_EXIST);
            json.put("apiVersion", apiVersionClient);

            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(path = SurveyEndpoint.SURVEY, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSurveyById(@PathVariable("id") String id, @RequestHeader(value = "X-API-VERSION") int apiVersionClient) {

        LOGGER.info("SurveyController:: apiVersionClient : " + apiVersionClient);
        // on pourra accéder à la liste des versions qui existe.
        ApiHeader apiHeader = new ApiHeader();
        // si la version de l'api du client existe et qu'il ne s'agit pas de la version stable
        if (apiHeader.listVersion.contains(apiVersionClient) && apiVersionClient != ApiHeader.STABLE_VERSION) {
            // on prépare la réponse
            JSONObject json = new JSONObject();
            json.put("status", ApiConstants.BAD_REQUEST);
            json.put("message", ApiConstants.API_VERSION_NOT_STABLE);
            json.put("apiVersion", apiVersionClient);

            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
            // si la version de l'api du client existe et qu'il s'agit de la version stable
        } else if (apiHeader.listVersion.contains(apiVersionClient) && apiVersionClient == ApiHeader.STABLE_VERSION) {

            LOGGER.info("SurveyController::: id : " + id);

            try {
                Survey survey = surveyService.getSurveyById(id);

                return ResponseEntity.ok(survey);
            } catch (RuntimeException e) {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found", e);
            }
            // la version de l'api du client n'existe pas
        } else {

            JSONObject json = new JSONObject();
            json.put("status", ApiConstants.BAD_REQUEST);
            json.put("message", ApiConstants.API_VERSION_DOESNT_EXIST);
            json.put("apiVersion", apiVersionClient);

            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
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
