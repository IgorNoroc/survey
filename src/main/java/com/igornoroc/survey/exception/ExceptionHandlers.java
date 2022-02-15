package com.igornoroc.survey.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> errorAuthentication() {
        return ResponseEntity.badRequest().body("ошибка при вводе: имя или пароль");
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> errorDelete() {
        return ResponseEntity.badRequest().body("такой сущности не существует");
    }

    @ExceptionHandler(SurveyNotFoundException.class)
    public ResponseEntity<?> errorFindSurvey() {
        return ResponseEntity.badRequest().body("такого опроса не существует");
    }

    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<?> errorFindQuestion() {
        return ResponseEntity.badRequest().body("такого вопроса не существует");
    }
}
