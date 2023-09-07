package com.exam.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String content;

    private String image;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;

    private Date createdTime;

    private Boolean isActive;

    private String type;

    @Transient
    private String selectedAnswer;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}
