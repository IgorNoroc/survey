package com.igornoroc.survey.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;
}
