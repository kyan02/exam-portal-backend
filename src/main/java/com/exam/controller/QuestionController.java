package com.exam.controller;


import com.exam.entity.Attempt;
import com.exam.entity.Question;
import com.exam.entity.User;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){

        Question newQuestion = questionService.addQuestion(question);

        return ResponseEntity.status(HttpStatus.OK).body(newQuestion);
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){

        Question updatedQuestion = questionService.updateQuestion(question);

        return ResponseEntity.status(HttpStatus.OK).body(updatedQuestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id){

        Question question = questionService.getQuestion(id);

        return ResponseEntity.status(HttpStatus.OK).body(question);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestion(){

        List<Question> question = questionService.getAllQuestion();

        return ResponseEntity.status(HttpStatus.OK).body(question);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getAllQuestionOfQuiz(@PathVariable("quizId") Long id){

        List<Question> questions = questionService.getAllQuestionOfQuiz(id);
        Collections.shuffle(questions);

        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId){

        questionService.deleteQuestion(questionId);
    }

    //evaluate Quiz here
    @PostMapping("eval-quiz/{userId}")
    public ResponseEntity<?> evalQuiz(
            @PathVariable("userId") Long userId,
            @RequestBody List<Question> questions){
        System.out.println(questions);
        Map<String,Object> result  = questionService.evaluateQuiz(questions,userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
