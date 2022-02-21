package com.antoine.quizz.repository;
import com.antoine.quizz.model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/// ici on dispose des méthodes toute faite de mongoRepository comme findAll
@Repository
public interface SurveyRepository extends MongoRepository<Survey, String> {

}
