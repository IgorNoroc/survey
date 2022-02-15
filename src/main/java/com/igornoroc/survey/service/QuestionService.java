package com.igornoroc.survey.service;

import com.igornoroc.survey.entity.Question;


public interface QuestionService  {
    Question create(Question question, Long surveyId);

    Question updateTextQuestion(Question question);

    Question updateTypeQuestion(Question question);

    void delete(Long surveyId, Long questionId);
}
