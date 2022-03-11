package com.antoine.quizz.fixtureTest;

import com.antoine.quizz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionsFakeTest {
    public static final int QUESTION = 5;

    public List<Question> getQuestions() {
        List<Question> questionList = new ArrayList<>();

        for (int i = 1; i <= QUESTION; i++) {

            Question question = new Question(Integer.toString(i), "question" + i);
            questionList.add(question);
        }
        return questionList;
    }
}

