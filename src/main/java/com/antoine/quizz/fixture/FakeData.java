package com.antoine.quizz.fixture;

import com.antoine.quizz.repository.ISurveyRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FakeData {


    ISurveyRepository ISurveyRepository;
    GetSurveysFake getSurveysFake;

    public FakeData(ISurveyRepository ISurveyRepository, GetSurveysFake getSurveysFake) {
        this.ISurveyRepository = ISurveyRepository;
        this.getSurveysFake = getSurveysFake;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        ISurveyRepository.deleteAll();
        ISurveyRepository.insert(getSurveysFake.getSurveys());

    }

}
