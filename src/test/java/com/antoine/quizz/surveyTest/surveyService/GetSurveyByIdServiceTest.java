package com.antoine.quizz.surveyTest.surveyService;

import com.antoine.quizz.fixtureTest.GetSurveysFakeTest;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.repository.ISurveyRepository;
import com.antoine.quizz.service.surveyService.SurveyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GetSurveyByIdServiceTest {
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
    public void getSurveyByIdTest() {
        //GIVEN
        Survey survey = getSurveysFakeTest.getSurveys()
                .get(0);

        Mockito.when(iSurveyRepository.findById(survey.getId()))
                .thenReturn(Optional.of(survey));
        //WHEN
        final Survey res = surveyServiceImpl.getSurveyById(survey.getId());

        //THEN
        Assertions.assertEquals(survey, res);
    }


    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = " ")
    public void getInvalidArgSurveyByIdTest(String id) {
        //GIVEN

        Optional<Survey> optional = Optional.empty();

        Mockito.when(iSurveyRepository.findById(id))
                .thenReturn(optional);


        //THEN
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            //WHEN
            surveyServiceImpl.getSurveyById(id);
        });
    }


}
