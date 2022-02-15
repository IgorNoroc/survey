package com.igornoroc.survey.rest;

import com.igornoroc.survey.entity.Survey;
import com.igornoroc.survey.service.SurveyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService surveyService;

    @ApiOperation(value = "добавить новый опрос")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public Survey addNEwSurvey(@RequestBody Survey survey) {
        return surveyService.save(survey);
    }

    @ApiOperation(value = "получить все опросы")
    @GetMapping("/get_all")
    public Collection<Survey> getAll() {
        return surveyService.findAll();
    }

    @ApiOperation(value = "изменить имя опроса")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update_name")
    public Survey updateName(@RequestBody Survey survey) {
        return surveyService.updateSurveyName(survey);
    }

    @ApiOperation(value = "изменить описание опроса")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update_description")
    public Survey updateDescription(@RequestBody Survey survey) {
        return surveyService.updateSurveyDescription(survey);
    }

    @ApiOperation(value = "изменить список вопросов опроса")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update_questions")
    public Survey updateQuestions(@RequestBody Survey survey) {
        return surveyService.updateSurveyQuestions(survey);
    }

    @ApiOperation(value = "удалить опрос")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
        return String.format("опрос с идентификором %d был удалён", id);
    }
}
