package com.antoine.quizz.surveyTest.surveyService;

import com.antoine.quizz.fixtureTest.GetSurveysFakeTest;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.repository.ISurveyRepository;
import com.antoine.quizz.service.surveyService.SurveyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GetSurveysServiceTest {

    @Mock
    private ISurveyRepository ISurveyRepository;

    private SurveyServiceImpl surveyServiceImpl;

    private GetSurveysFakeTest getSurveysFakeTest;


    @BeforeEach
    void setUp() {
        surveyServiceImpl = new SurveyServiceImpl(ISurveyRepository);
        getSurveysFakeTest = new GetSurveysFakeTest();
    }

    @Test
    public void getAllSurveysTest() {
        //GIVEN
        List<Survey> surveyList = getSurveysFakeTest.getSurveys();

        Mockito.when(ISurveyRepository.findAll())
                .thenReturn(surveyList);
        //WHEN
        final List<Survey> res = surveyServiceImpl.getSurveys();

        //THEN
        Assertions.assertEquals(surveyList, res);
    }

    @Test
    public void getAnySurveysTest() {
        //GIVEN
        List<Survey> surveyList = new ArrayList<>();

        Mockito.when(ISurveyRepository.findAll())
                .thenReturn(surveyList);

        //WHEN
        final List<Survey> res = surveyServiceImpl.getSurveys();

        //THEN
        Assertions.assertEquals(surveyList, res);
    }

    @Test
    public void getNullSurveyTest() {
        //GIVEN
        Mockito.when(ISurveyRepository.findAll())
                .thenReturn(null);

        //WHEN
        final List<Survey> res = surveyServiceImpl.getSurveys();

        //THEN
        Assertions.assertNull(res);
    }


}
