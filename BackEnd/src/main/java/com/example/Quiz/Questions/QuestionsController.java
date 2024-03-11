package com.example.Quiz.Questions;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/questions")
//@CrossOrigin(origins = "http://localhost:1234")
public class QuestionsController {
    private final QuestionsService questionsService;
    public QuestionsController(QuestionsService questionsService){
        this.questionsService = questionsService;
    }
    @GetMapping("/id/{quizId}")// Request GET do konkretnego id quizu
    public List<Questions> getAllQuestion(@PathVariable Integer quizId){

        return questionsService.getAllQuestionsByQuizId(quizId);
    }
    @PostMapping("/{quizId}")//Dodanie pytania do konkretnego id quizu
    public void insertQuestions(
            @PathVariable("quizId") Integer quizId,
            @RequestBody AddQuestions request)
    {
             questionsService.addQuestions(request, quizId);
    }
}
