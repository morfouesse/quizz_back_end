package com.antoine.quizz.fixtureTest;

import com.antoine.quizz.model.Survey;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSurveysFakeTest {


    public static final int SURVEYS = 5;

    public List<Survey> getSurveys() {
        List<Survey> surveyList = new ArrayList<>();

        for (int i = 1; i <= SURVEYS; i++) {

            Survey survey = new Survey(Integer.toString(i), "survey" + i);
            surveyList.add(survey);
        }
        return surveyList;
    }
}
