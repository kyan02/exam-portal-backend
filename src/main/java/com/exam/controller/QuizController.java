package com.exam.controller;

import com.exam.entity.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){

        Quiz newQuiz = quizService.addQuiz(quiz);

        return ResponseEntity.status(HttpStatus.OK).body(newQuiz);
    }

    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){

        Quiz updatedQuiz = quizService.updateQuiz(quiz);

        return ResponseEntity.status(HttpStatus.OK).body(updatedQuiz);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("id") Long id){

        Quiz quiz = quizService.getQuiz(id);

        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuiz(){

        List<Quiz> quizs = quizService.getAllQuiz();

        return ResponseEntity.status(HttpStatus.OK).body(quizs);
    }

    @PatchMapping("/")
    public ResponseEntity<Quiz> deleteQuiz(@RequestBody Quiz q){

        Quiz quiz = quizService.deleteQuiz(q);

        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Quiz>> getQuizs(@PathVariable("categoryId") Long categoryId){

        List<Quiz> quiz = quizService.getAllQuizsOfCategory(categoryId);

        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }
}
