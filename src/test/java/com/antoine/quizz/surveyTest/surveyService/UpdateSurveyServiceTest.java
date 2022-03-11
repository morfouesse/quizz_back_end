package com.antoine.quizz.surveyTest.surveyService;

import com.antoine.quizz.fixtureTest.GetSurveysFakeTest;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.service.surveyService.SurveyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpdateSurveyServiceTest {
    @Mock
    private com.antoine.quizz.repository.ISurveyRepository iSurveyRepository;

    private SurveyServiceImpl surveyServiceImpl;

    private GetSurveysFakeTest getSurveysFakeTest;


    @BeforeEach
    void setUp() {
        surveyServiceImpl = new SurveyServiceImpl(iSurveyRepository);
        getSurveysFakeTest = new GetSurveysFakeTest();
    }

    @Test
    public void updateSurveyTest() {
        //GIVEN
        Survey survey = getSurveysFakeTest.getSurveys()
                .get(0);

        //WHEN
        surveyServiceImpl.updateSurvey(survey);

        //THEN
        // nous sommes dans une méthode void, donc on vérifie seulement la dépendance.
        Mockito.verify(iSurveyRepository, Mockito.times(1))
                .save(survey);
    }


}
