package com.igornoroc.survey.service.impl;

import com.igornoroc.survey.entity.Question;
import com.igornoroc.survey.entity.Survey;
import com.igornoroc.survey.exception.QuestionNotFoundException;
import com.igornoroc.survey.repository.QuestionRepo;
import com.igornoroc.survey.service.QuestionService;
import com.igornoroc.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepo questionRepo;
    private final SurveyService surveyService;

    @Override
    public Question create(Question question, Long surveyId) {
        Survey currentSurvey = surveyService.findById(surveyId);
        currentSurvey.getQuestions().add(question);
        surveyService.updateSurveyQuestions(currentSurvey);
        return questionRepo.save(question);
    }

    @Override
    public Question updateTextQuestion(Question question) {
        return update(question, (currentQuestion) -> currentQuestion.setText(question.getText()));
    }

    @Override
    public Question updateTypeQuestion(Question question) {
        return update(question, (currentQuestion) -> currentQuestion.setType(question.getType()));
    }

    @Override
    public void delete(Long surveyId, Long questionId) {
        Survey updateSurvey = surveyService.findById(surveyId);
        Question deleteQuestion = updateSurvey.getQuestions().stream()
                .filter(question -> Objects.equals(question.getId(), questionId))
                .findFirst()
                .orElseThrow(QuestionNotFoundException::new);
        updateSurvey.getQuestions().remove(deleteQuestion);
        surveyService.save(updateSurvey);
    }

    /**
     * Универсальный метод для обновления сущности Question.
     *
     * @param question Обновляемая сущность.
     * @param consumer действие над сущностью.
     */
    private Question update(Question question, Consumer<Question> consumer) {
        Question currentQuestion = questionRepo.findById(question.getId())
                .orElseThrow(QuestionNotFoundException::new);
        consumer.accept(currentQuestion);
        return questionRepo.save(currentQuestion);
    }


}
