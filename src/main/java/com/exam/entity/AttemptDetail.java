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
public class AttemptDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long userId;
    private Date attemptedOn;
    private String selectedAns;
    private Boolean isCorrect;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "question_id")
    private Question question;
}
