package com.antoine.quizz.surveyTest;

import com.antoine.quizz.TestRequestFactory;
import com.antoine.quizz.apiElementsTest.ApiEndpointsTest;
import com.antoine.quizz.apiElementsTest.MethodsHttp;
import com.antoine.quizz.fixtureTest.GetSurveysFakeTest;
import com.antoine.quizz.model.Survey;
import com.antoine.quizz.service.surveyService.SurveyServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// tdd aprentissage, plus révision SOLID
// https://www.invivoo.com/replay/replay-invivoo-initiation-tdd-session-1-et-2.mp4
// FIRST
// https://openclassrooms.com/fr/courses/6100311-testez-votre-code-java-pour-realiser-des-applications-de-qualite/6440801-appliquez-le-principe-first-pour-ecrire-de-bons-tests


@SpringBootTest
@AutoConfigureMockMvc
public class SurveyControllerTest {


    // @Autowired
    //  ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GetSurveysFakeTest getSurveysFakeTest;

    @MockBean
    private SurveyServiceImpl surveyServiceImpl;


    @Test
    public void testGetSurveys() throws Exception {

        //WHEN
        Mockito.when(surveyServiceImpl.getSurveys())
                .thenReturn(
                        //THEN
                        getSurveysFakeTest.getSurveys());


        mockMvc.perform(Objects.requireNonNull(
                        TestRequestFactory.factoryGetRequest(ApiEndpointsTest.SURVEYS_TEST,
                                MethodsHttp.get)))
                .andExpect(status().isOk())
                .andDo(print())
                // dans le resultat de test JSON, nous avons d'abord un objet
                .andExpect(jsonPath("$.[0].name", is("survey1")))
                .andExpect(jsonPath("$.size()", is(5)));
    }

    @Test
    public void testGetSurveyById() throws Exception {
        //GIVEN
        Survey survey = new Survey("5", "survey5");
        String id = "5";
        //WHEN
        Mockito.when(surveyServiceImpl.getSurveyById(id))
                .thenReturn(
                        //THEN
                        survey);


        mockMvc.perform(Objects.requireNonNull(
                        TestRequestFactory.factoryGetRequest(ApiEndpointsTest.SURVEY_TEST + id,
                                MethodsHttp.get)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is("survey5")))
                // il n'y a pas de liste d'objets, donc 2 valeurs attendu
                .andExpect(jsonPath("$.size()", is(2)));
    }

    // https://stackabuse.com/guide-to-unit-testing-spring-boot-rest-apis/
 /*   @Test
    public void testAddSurvey() throws Exception {

        //GIVEN
        Survey survey = new Survey("6", "survey6");

        //WHEN
        Mockito.when(surveyServiceImpl.addSurvey(survey))
                //THEN
                .thenReturn(survey);

        mockMvc.perform(Objects.requireNonNull(

                        Objects.requireNonNull(
                                        TestRequestFactory.factoryGetRequest(ApiEndpointsTest.CREATE_SURVEY_TEST,
                                                MethodsHttp.post))
                                .content(objectMapper.writeValueAsString(survey))))

                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is("survey6")))
                // il n'y a pas de liste d'objets, donc 2 valeurs attendu
                .andExpect(jsonPath("$.size()", is(2)));
    }*/
}
