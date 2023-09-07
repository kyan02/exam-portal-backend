package com.exam.service;

import com.exam.Repository.CategoryRepository;
import com.exam.Repository.QuizRepository;
import com.exam.entity.Category;
import com.exam.entity.Quiz;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuizService {

  @Autowired QuizRepository quizRepository;
  @Autowired CategoryRepository categoryRepository;

  public Quiz addQuiz(Quiz quiz) {

    Quiz existingQuiz = quizRepository.findOneByTitleAndIsActive(quiz.getTitle(), Boolean.TRUE);

    if (Objects.nonNull(existingQuiz)) {
      // error
    }

    quiz.setCreatedTime(DateTime.now().toDate());
    return quizRepository.save(quiz);
  }

  public Quiz updateQuiz(Quiz quiz) {

    Quiz existingQuiz = quizRepository.findOneByTitle(quiz.getTitle());


      if (Objects.nonNull(existingQuiz)) {
          Category category = categoryRepository.findById(quiz.getId()).get();
          existingQuiz.setTitle(quiz.getTitle());
          existingQuiz.setDescription(quiz.getDescription());
          existingQuiz.setMaxMarks(quiz.getMaxMarks());
          existingQuiz.setNumberOfQuestions(quiz.getNumberOfQuestions());
          existingQuiz.setIsActive(quiz.getIsActive());
          existingQuiz.setCategory(category);
          quizRepository.save(existingQuiz);
      }

     return existingQuiz;
  }

  public Quiz getQuiz(Long id){

    return quizRepository.findById(id).get();
  }

  public List<Quiz> getAllQuiz(){

    return quizRepository.findAll();
  }

  public Quiz deleteQuiz(Quiz quiz){

      Quiz existingQuiz = quizRepository.findById(quiz.getId()).get();
      existingQuiz.setIsActive(Boolean.FALSE);

      return quizRepository.save(existingQuiz);
  }

    public List<Quiz> getAllQuizsOfCategory(Long id){

        return quizRepository.findAllByCategoryIdAndIsActive(id, Boolean.TRUE);
    }
}
