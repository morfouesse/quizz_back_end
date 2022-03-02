package com.antoine.quizz.fake_data;

import com.antoine.quizz.model.Survey;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSurveysFake {


    public List<Survey> getSurveys() {
        List<Survey> surveyList = new ArrayList<>();

        for (int i = 1; i <= FakeData.SURVEYS; i++) {

            Survey survey = new Survey(Integer.toString(i), "survey" + i);
            surveyList.add(survey);
        }
        return surveyList;
    }
}
