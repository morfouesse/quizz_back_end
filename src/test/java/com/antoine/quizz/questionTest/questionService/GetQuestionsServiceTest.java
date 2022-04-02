package com.antoine.quizz.questionTest.questionService;

import com.antoine.quizz.fixtureTest.GetQuestionsFakeTest;
import com.antoine.quizz.model.Question;
import com.antoine.quizz.repository.IQuestionRepository;
import com.antoine.quizz.service.QuestionsService.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class GetQuestionsServiceTest {

    @Mock
    private IQuestionRepository iQuestionRepository = mock(IQuestionRepository.class);

    private QuestionServiceImpl questionService;

    private GetQuestionsFakeTest getQuestionsFakeTest;

    @BeforeEach
    void setUp() {
        questionService = new QuestionServiceImpl(iQuestionRepository);
        getQuestionsFakeTest = new GetQuestionsFakeTest();
    }

    @Test
    public void getQuestionsTest() {
        //GIVEN
        List<Question> questions = getQuestionsFakeTest.getQuestions();
        questionService.getQuestions();

        //WHEN
        Mockito.verify(iQuestionRepository, Mockito.times(1))
                .findAll();
    }
}
