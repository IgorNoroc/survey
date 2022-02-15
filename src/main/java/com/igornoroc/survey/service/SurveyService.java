package com.igornoroc.survey.service;

import com.igornoroc.survey.entity.Survey;

import java.util.Collection;

public interface SurveyService {
    Survey save(Survey survey);

    Survey updateSurveyName(Survey survey);

    Survey updateSurveyDescription(Survey survey);

    Survey updateSurveyQuestions(Survey survey);

    Collection<Survey> findAll();

    Survey findById(Long id);

    void deleteSurvey(Long id);
}
