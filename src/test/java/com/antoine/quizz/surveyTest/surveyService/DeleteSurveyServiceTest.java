package com.antoine.quizz.surveyTest.surveyService;

import com.antoine.quizz.fixtureTest.GetSurveysFakeTest;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.repository.ISurveyRepository;
import com.antoine.quizz.service.surveyService.SurveyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class DeleteSurveyServiceTest {
    @Mock
    private ISurveyRepository iSurveyRepository = mock(ISurveyRepository.class);

    private SurveyServiceImpl surveyServiceImpl;

    private GetSurveysFakeTest getSurveysFakeTest;


    @BeforeEach
    void setUp() {
        surveyServiceImpl = new SurveyServiceImpl(iSurveyRepository);
        getSurveysFakeTest = new GetSurveysFakeTest();
    }

    @Test
    public void deleteSurveyTest() {
        //GIVEN
        Survey survey = getSurveysFakeTest.getSurveys()
                .get(0);

        //WHEN
        surveyServiceImpl.deleteSurvey(Integer.parseInt(survey.getId()));

        //THEN
        // nous sommes dans une méthode void, donc on vérifie seulement la dépendance.
        Mockito.verify(iSurveyRepository, Mockito.times(1))
                .deleteById(survey.getId());
    }


    @Test
    public void notFoundIdSurveyTest() {
        //GIVEN
        int id = 1000;
        iSurveyRepository.deleteById(String.valueOf(id));


        Mockito.verify(iSurveyRepository, Mockito.times(1))
                .deleteById(String.valueOf(id));
    }


}