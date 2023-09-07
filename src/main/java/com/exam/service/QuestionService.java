package com.exam.service;

import com.exam.Repository.QuestionRepository;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.entity.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AttemptService attemptService;
    @Autowired
    AttemptDetailService attemptDetailService;

    public Question addQuestion(Question question){

        Question existingQuestion = questionRepository.findOneByContentAndIsActive(question.getContent(), Boolean.TRUE);

        if(Objects.nonNull(existingQuestion)){
            //error
        }
        question.setIsActive(Boolean.TRUE);
        question.setCreatedTime(DateTime.now().toDate());

        return questionRepository.save(question);
    }

    public  Question updateQuestion(Question question){

        Question existingQuestion = questionRepository.findOneByContentAndIsActive(question.getContent(), Boolean.TRUE);

        if (Objects.nonNull(existingQuestion)) {
            existingQuestion.setContent(question.getContent());
            existingQuestion.setAnswer(question.getAnswer());
            existingQuestion.setOption1(question.getOption1());
            existingQuestion.setOption2(question.getOption2());
            existingQuestion.setOption3(question.getOption3());
            existingQuestion.setOption4(question.getOption4());
            existingQuestion.setType(question.getType());
            existingQuestion.setImage(question.getImage());
            existingQuestion.setIsActive(Boolean.TRUE);
        }

        return existingQuestion;
    }

    public Question getQuestion(Long id){

        return questionRepository.findById(id).get();
    }

    public List<Question> getAllQuestion(){

        return questionRepository.findAll();
    }

    public List<Question> getAllQuestionOfQuiz(Long id){

        return questionRepository.findAllByQuizIdAndIsActive(id, Boolean.TRUE);
    }

    public void deleteQuestion(Long id){

        Question question = questionRepository.findById(id).get();
        question.setIsActive(Boolean.FALSE);
        questionRepository.save(question);
    }

    public Map<String, Object> evaluateQuiz(List<Question> questions, Long user_id){

        Integer marks;
        Integer totalCorrectAnswer= 0;
        Integer attempted= 0;
        Set<Long> questionIds = questions.stream().map(Question::getId).collect(Collectors.toSet());
        List<Question> savedQuestions = questionRepository.findAllByIdIn(questionIds);
        Map<Long,String> answers = savedQuestions.stream().collect(Collectors.toMap(Question::getId, Question::getAnswer));
        for(Question question : questions){
            if(answers.containsKey(question.getId())){
                String correctAnswer = answers.get(question.getId());
                if(correctAnswer.trim().equalsIgnoreCase(question.getSelectedAnswer())){
                    totalCorrectAnswer++;
                }
            }
            if(Objects.nonNull(question.getSelectedAnswer()) && !(question.getSelectedAnswer().equalsIgnoreCase(""))){
                attempted++;
            }
        }
        marks = (  totalCorrectAnswer*100 / questions.size());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalMarks",marks);
        resultMap.put("totalCorrectAnswer",totalCorrectAnswer);
        resultMap.put("attempted",attempted);

        attemptService.saveAttemptDetails(questions.get(0).getQuiz(), resultMap, user_id);
        attemptDetailService.saveAttemptDetailReport(questions, user_id);

        return resultMap;
    }
}
