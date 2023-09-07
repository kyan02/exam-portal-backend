package com.exam.service;

import com.exam.Repository.AttemptRepository;
import com.exam.entity.Attempt;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AttemptService {

  @Autowired
  AttemptRepository attemptRepository;


  public List<Attempt> getAllAttempts(){

    return attemptRepository.findAll();
  }
  @Async
  public void saveAttemptDetails(Quiz quiz, Map<String, Object> resultMap, Long userId) {

      Attempt attempt = new Attempt();
      attempt.setAttemptedOn(DateTime.now().toDate());
      attempt.setScore(resultMap.get("totalMarks").toString());
      attempt.setTotalCorrectAnswer(resultMap.get("totalCorrectAnswer").toString());
      attempt.setTotalAttempted(resultMap.get("attempted").toString());
      attempt.setQuiz(quiz);
      attempt.setUserId(userId);
      if(Integer.parseInt(attempt.getScore())>60)
          attempt.setResult(Boolean.TRUE);
      else
        attempt.setResult(Boolean.FALSE);
      attemptRepository.save(attempt);
    }
}
