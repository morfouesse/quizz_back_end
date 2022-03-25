package com.antoine.quizz.service.QuestionsService;

import com.antoine.quizz.model.Question;
import com.antoine.quizz.repository.IQuestionRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionRepository iQuestionRepository;

    public QuestionServiceImpl(IQuestionRepository iQuestionRepository) {
        this.iQuestionRepository = iQuestionRepository;
    }

    @Override
    public List<Question> getQuestions() {

        return iQuestionRepository.findAll();
    }

    @Override
    public Question getQuestionById(@NonNull String id) {

        Optional<Question> question = iQuestionRepository.findById(id);

        return question.orElseThrow();
    }

    @Override
    public void addQuestion(@NonNull Question question) {
        iQuestionRepository.save(question);
    }

    @Override
    public void updateQuestion(@NonNull Question question) {
        iQuestionRepository.save(question);
    }

    @Override
    public void deleteQuestion(@NonNull String id) {
        iQuestionRepository.deleteById(id);
    }
}
