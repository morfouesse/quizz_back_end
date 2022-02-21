package com.antoine.quizz.service;

import com.antoine.quizz.dto.SurveyDTO;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.repository.SurveyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;


    public SurveyService() {

    }

    public List<Survey> getSurveys() {
        return surveyRepository.findAll();
    }

    public Survey getSurveyById(String id) {

        Optional<Survey> survey = surveyRepository.findById(id);
        //si survey n'es pas null, on récupere ces données sinon on leve une exception
        return survey.orElseThrow();

    }


    public Survey addSurvey(SurveyDTO surveyDTO) {
        ModelMapper modelMapper = new ModelMapper();
        // on transfere la data du client dans notre modèle
        Survey survey = modelMapper.map(surveyDTO, Survey.class);
        return surveyRepository.insert(survey);
    }

    public Survey updateSurvey(SurveyDTO surveyDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Survey survey = modelMapper.map(surveyDTO, Survey.class);
        return surveyRepository.save(survey);
    }


    public String deleteSurvey(String id) {
        surveyRepository.deleteById(id);
        return id;
    }
}
