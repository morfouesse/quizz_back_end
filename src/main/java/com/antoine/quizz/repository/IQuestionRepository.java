package com.antoine.quizz.repository;

import com.antoine.quizz.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends MongoRepository<Question, String> {

}
