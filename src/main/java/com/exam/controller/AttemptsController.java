package com.exam.controller;


import com.exam.entity.Attempt;
import com.exam.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/attempts")
public class AttemptsController {

    @Autowired
    AttemptService attemptService;

    @GetMapping("/")
    public ResponseEntity<List<Attempt>> getAllAttempts(){

        List<Attempt> attempts = attemptService.getAllAttempts();

        return ResponseEntity.status(HttpStatus.OK).body(attempts);
    }
}
