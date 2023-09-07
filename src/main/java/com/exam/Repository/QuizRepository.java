package com.exam.Repository;

import com.exam.entity.Category;
import com.exam.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findOneByTitleAndIsActive(String title, Boolean isActive);

    Quiz findOneByTitle(String title);

    List<Quiz> findAllByCategoryIdAndIsActive(Long categoryId, Boolean isActive);

}
