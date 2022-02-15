package com.igornoroc.survey.service;


import com.igornoroc.survey.entity.UserAnswer;

import java.util.Collection;

public interface UserAnswerService {
    UserAnswer save(UserAnswer userAnswer);

    Collection<UserAnswer> findAllAnswersByUserId(String userId);
}
