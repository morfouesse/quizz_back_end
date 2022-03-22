package com.antoine.quizz.fixture;

import com.antoine.quizz.model.Survey;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSurveysFake {

    public static final int SURVEYS = 10;

    public List<Survey> getSurveys() {
        List<Survey> surveyList = new ArrayList<>();

        for (int i = 1; i <= SURVEYS; i++) {

            Survey survey = new Survey(Integer.toString(i), "survey" + i);
            surveyList.add(survey);
        }
        return surveyList;
    }
}
