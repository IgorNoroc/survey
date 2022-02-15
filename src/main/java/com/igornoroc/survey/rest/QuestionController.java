package com.igornoroc.survey.rest;

import com.igornoroc.survey.entity.Question;
import com.igornoroc.survey.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @ApiOperation(value = "добавить новый вопрос в опрос")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add/{surveyId}")
    public Question create(@RequestBody Question question, @PathVariable Long surveyId) {
        return questionService.create(question, surveyId);
    }

    @ApiOperation(value = "изменить вопрос в опросе")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update_text")
    public Question updateText(@RequestBody Question question) {
        return questionService.updateTextQuestion(question);
    }

    @ApiOperation(value = "изменить тип вопроса")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update_type")
    public Question updateType(@RequestBody Question question) {
        return questionService.updateTypeQuestion(question);
    }

    @ApiOperation(value = "удалить вопрос из опроса")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{survey_id}/{question_id}")
    public String deleteQuestion(@PathVariable Long survey_id, @PathVariable Long question_id) {
        questionService.delete(survey_id, question_id);
        return String.format("вопрос с идентификором %d был удалён", question_id);
    }
}
