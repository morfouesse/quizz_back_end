package com.antoine.quizz;

import com.antoine.quizz.questionTest.questionService.GetQuestionsServiceTest;
import com.antoine.quizz.surveyTest.SurveyControllerTest;
import com.antoine.quizz.surveyTest.surveyService.*;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({GetSurveysServiceTest.class, GetSurveyByIdServiceTest.class, AddSurveyServiceTest.class, UpdateSurveyServiceTest.class, DeleteSurveyServiceTest.class, SurveyControllerTest.class, GetQuestionsServiceTest.class})
public class SuiteTest {
}
