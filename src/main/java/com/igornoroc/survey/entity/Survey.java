package com.igornoroc.survey.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey")
@Data
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(name = "start_survey", updatable = false)
    private Date startSurvey;
    @Column(name = "finish_survey")
    private Date finishSurvey;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @PrePersist
    private void setStartSurvey() {
        startSurvey = new Date();
    }
}
