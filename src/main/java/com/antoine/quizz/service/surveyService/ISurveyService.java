package com.antoine.quizz.service.surveyService;

import com.antoine.quizz.model.Survey;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ISurveyService {

    List<Survey> getSurveys();

    Survey getSurveyById(@NonNull String id);

    void addSurvey(@NonNull Survey survey);

    void updateSurvey(@NonNull Survey survey);

    void deleteSurvey(@NonNull String id);

}