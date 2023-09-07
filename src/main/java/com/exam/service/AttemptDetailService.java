package com.exam.service;

import com.exam.Repository.AttemptDetailRepository;
import com.exam.entity.AttemptDetail;
import com.exam.entity.Question;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AttemptDetailService {

  @Autowired AttemptDetailRepository attemptDetailRepository;

  public List<AttemptDetail> getAttemptDetails() {

    return attemptDetailRepository.findAll();
  }

  @Async
  public void saveAttemptDetailReport(List<Question> questions, Long userId) {

    for (Question question : questions) {
      AttemptDetail attemptDetail = new AttemptDetail();
      attemptDetail.setAttemptedOn(DateTime.now().toDate());
      attemptDetail.setUserId(userId);
      attemptDetail.setSelectedAns(question.getSelectedAnswer());
      attemptDetail.setQuestion(question);
      if(Objects.equals(question.getSelectedAnswer(),question.getAnswer()))
        attemptDetail.setIsCorrect(Boolean.TRUE);
      else
        attemptDetail.setIsCorrect(Boolean.FALSE);
      attemptDetailRepository.save(attemptDetail);
    }
  }
}
