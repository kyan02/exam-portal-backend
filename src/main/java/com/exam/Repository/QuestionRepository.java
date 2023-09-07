package com.exam.Repository;

import com.exam.entity.Category;
import com.exam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findOneByContentAndIsActive(String content, Boolean isActive);

    List<Question> findAllByQuizIdAndIsActive(Long id, Boolean isActive);

    List<Question> findAllByIdIn(Set<Long> ids);
}
