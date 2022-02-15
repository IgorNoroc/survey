package com.igornoroc.survey.rest;

import com.igornoroc.survey.entity.UserAnswer;
import com.igornoroc.survey.service.UserAnswerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/user_answer")
@RequiredArgsConstructor
public class UserAnswerController {
    private final UserAnswerService userAnswerService;

    @ApiOperation(value = "создать ответ пользователя")
    @PostMapping("/create")
    public UserAnswer create(@RequestBody UserAnswer userAnswer) {
        return userAnswerService.save(userAnswer);
    }

    @ApiOperation(value = "найти все ответы пользователя")
    @GetMapping("/find_by_id/{userid}")
    public Collection<UserAnswer> getAll(@PathVariable String userid) {
        return userAnswerService.findAllAnswersByUserId(userid);
    }
}
