package com.igornoroc.survey.repository;

import com.igornoroc.survey.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserAnswerRepo extends JpaRepository<UserAnswer, Long> {
    Collection<UserAnswer> findByUserId(String userId);
}
