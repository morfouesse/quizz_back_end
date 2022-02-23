package com.antoine.quizz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class QuizzApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetSurveys() throws Exception {

        mockMvc.perform(MyTestRequestFactory
                        .myFactoryGetRequest("/surveys"))

                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // dans le resultat de test JSON, nous avons d'abord un objet
                .andExpect(jsonPath("$._embedded.surveys[0].name", is("survey1")));
    }
}
