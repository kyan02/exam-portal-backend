package com.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long userId;
    private Date attemptedOn;
    private String score;
    private String totalCorrectAnswer;
    private String totalAttempted;
    private Boolean result;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
