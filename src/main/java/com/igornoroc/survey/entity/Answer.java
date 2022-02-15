package com.igornoroc.survey.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
}
