package com.igornoroc.survey.service.impl;

import com.igornoroc.survey.entity.Survey;
import com.igornoroc.survey.exception.SurveyNotFoundException;
import com.igornoroc.survey.repository.SurveyRepo;
import com.igornoroc.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepo surveyRepo;

    @Override
    public Survey save(Survey survey) {
        return surveyRepo.save(survey);
    }


    @Override
    public Survey updateSurveyName(Survey survey) {
        return update(survey, (currentSurvey) -> currentSurvey.setName(survey.getName()));
    }

    @Override
    public Survey updateSurveyDescription(Survey survey) {
        return update(survey, (currentSurvey) -> currentSurvey.setDescription(survey.getDescription()));
    }

    @Override
    public Survey updateSurveyQuestions(Survey survey) {
        return update(survey, (currentSurvey) -> currentSurvey.getQuestions().addAll(survey.getQuestions()));
    }

    @Override
    public Collection<Survey> findAll() {
        return surveyRepo.findAll();
    }

    @Override
    public Survey findById(Long id) {
        return surveyRepo.findById(id)
                .orElseThrow(SurveyNotFoundException::new);
    }

    @Override
    public void deleteSurvey(Long id) {
        surveyRepo.deleteById(id);
    }

    /**
     * Универсальный метод для обновления сущности Survey.
     *
     * @param survey   Обновляемая сущность.
     * @param consumer действие над сущностью.
     */
    private Survey update(Survey survey, Consumer<Survey> consumer) {
        Survey currentSurvey = surveyRepo.findById(survey.getId())
                .orElseThrow(SurveyNotFoundException::new);
        consumer.accept(currentSurvey);
        return surveyRepo.save(currentSurvey);
    }
}
