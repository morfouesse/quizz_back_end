package com.antoine.quizz.service.surveyService;

import com.antoine.quizz.model.Survey;
import com.antoine.quizz.repository.ISurveyRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements ISurveyService {

    private final ISurveyRepository ISurveyRepository;


    public SurveyServiceImpl(ISurveyRepository ISurveyRepository) {
        this.ISurveyRepository = ISurveyRepository;
    }

    @Override
    public List<Survey> getSurveys() {
        return ISurveyRepository.findAll();
    }

    @Override
    public Survey getSurveyById(@NonNull String id) {

        Optional<Survey> survey = ISurveyRepository.findById(id);
        //si survey n'es pas null, on récupere ces données sinon on leve une exception
        return survey.orElseThrow();
    }

    @Override
    public void addSurvey(@NonNull Survey survey) {

        ISurveyRepository.save(survey);

    }

    @Override
    public void updateSurvey(@NonNull Survey survey) {
        ISurveyRepository.save(survey);
    }

    @Override
    public void deleteSurvey(@NonNull String id) {
        ISurveyRepository.deleteById(id);
    }
}
