package com.antoine.quizz.service.surveyService;

import com.antoine.quizz.model.Survey;

import java.util.List;

public interface ISurveyService {

    public List<Survey> getSurveys();

    public Survey getSurveyById(String id);

    public void addSurvey(Survey survey);

    public void updateSurvey(Survey survey);

    public void deleteSurvey(String id);

}