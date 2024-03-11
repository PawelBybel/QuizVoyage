package com.example.Quiz.Answers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api/v1/answers")
//@CrossOrigin(origins = "http://localhost:1234")
public class AnswersController {
    private final AnswersService answersService;

    public AnswersController(AnswersService answersService) {
        this.answersService = answersService;
    }

    @PostMapping("/{questionsId}")
    public void insertAnswers(
            @PathVariable("questionsId") Integer questionsId,
            @RequestBody AddAnswers request)
    {
             answersService.addAnswers(request, questionsId);
    }
    @GetMapping("/id/{questionId}")
    public List<Answers> getAllAnswers(){
        return answersService.getAllAnswers();
    }
}
