package com.antoine.quizz.service.QuestionsService;

import com.antoine.quizz.model.Question;
import org.springframework.lang.NonNull;

import java.util.List;

public interface IQuestionService {

    public List<Question> getQuestions();

    public Question getQuestionById(@NonNull String id);

    public void addQuestion(@NonNull Question question);

    public void updateQuestion(@NonNull Question question);

    public void deleteQuestion(@NonNull String id);
}
