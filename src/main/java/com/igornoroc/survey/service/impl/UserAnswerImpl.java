package com.igornoroc.survey.service.impl;

import com.igornoroc.survey.entity.UserAnswer;
import com.igornoroc.survey.repository.UserAnswerRepo;
import com.igornoroc.survey.service.UserAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserAnswerImpl implements UserAnswerService {
    private final UserAnswerRepo userAnswerRepo;

    @Override
    public UserAnswer save(UserAnswer userAnswer) {
        return userAnswerRepo.save(userAnswer);
    }

    @Override
    public Collection<UserAnswer> findAllAnswersByUserId(String userId) {
        return userAnswerRepo.findByUserId(userId);
    }
}
