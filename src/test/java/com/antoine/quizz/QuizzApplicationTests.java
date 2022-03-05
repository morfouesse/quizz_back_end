package com.antoine.quizz;

import com.antoine.quizz.fake_data.GetSurveysFake;
import com.antoine.quizz.service.SurveyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// tdd aprentissage, plus révision SOLID
// https://www.invivoo.com/replay/replay-invivoo-initiation-tdd-session-1-et-2.mp4

//Mockito permet de faire des tests d'intégrations, d'une méthode de controller
// qui appel une instance de classe comme un service
// Dnnc mockito permet de tester des fonctionnalités dépedant d'une autre classe
@SpringBootTest
@AutoConfigureMockMvc
class QuizzApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    GetSurveysFake getSurveysFake;

    @MockBean
    private SurveyService surveyService;

    private static final int isOK = 200;


    @Test
    public void testGetSurveys() throws Exception {

        Mockito.when(surveyService.getSurveys())
                .thenReturn(getSurveysFake.getSurveys());


        mockMvc.perform(TestRequestFactory.factoryGetRequest("/quizz/surveys"))
                .andExpect(status().isOk())
                .andDo(print())
                // dans le resultat de test JSON, nous avons d'abord un objet
                .andExpect(jsonPath("$.[0].name", is("survey1")))
                .andExpect(jsonPath("$.size()", is(5)));
    }

    @Test
    public void testGetSurveyById() throws Exception {
        String id = "1";
        Mockito.when(surveyService.getSurveyById(id))
                .thenReturn(getSurveysFake.getSurveys()
                        .get(0));


        mockMvc.perform(TestRequestFactory.factoryGetRequest("/quizz/survey/" + id))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is("survey1")))
                // il n'y a pas de liste d'objets, donc 2 valeurs attendu
                .andExpect(jsonPath("$.size()", is(2)));
    }


}
