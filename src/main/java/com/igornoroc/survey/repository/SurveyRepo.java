package com.igornoroc.survey.repository;

import com.igornoroc.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepo extends JpaRepository<Survey, Long> {
}
