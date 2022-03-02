package com.antoine.quizz.fake_data;

import com.antoine.quizz.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FakeData {

    // on se servira de ces variables pour les tests aussi
    public static final int SURVEYS = 5;


    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    GetSurveysFake getSurveysFake;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        if (surveyRepository.findAll()
                .size() != FakeData.SURVEYS) {
            surveyRepository.insert(getSurveysFake.getSurveys());
        }
    }


}
