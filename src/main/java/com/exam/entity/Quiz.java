package com.exam.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private String description;

    private String maxMarks;

    private String numberOfQuestions;

    private Boolean isActive;

    private String createdBy;

    private Date createdTime;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

}
