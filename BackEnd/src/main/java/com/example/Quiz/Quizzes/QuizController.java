package com.example.Quiz.Quizzes;

import com.example.Quiz.Questions.QuestionsRepository;
import com.example.Quiz.Questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/quiz")
//@CrossOrigin(origins = "http://localhost:1234")
public class QuizController {

    private final QuizRepository quizRepository;
    private final QuestionsRepository questionsRepository;
    private final QuizService quizService;
    private final QuestionsService questionsService;
    @Autowired
    public QuizController(QuizRepository quizRepository, QuestionsRepository questionsRepository, QuizService quizService, QuestionsService questionsService){
        this.quizRepository = quizRepository;
        this.questionsRepository = questionsRepository;
        this.quizService = quizService;
        this.questionsService = questionsService;
    }
        // List all avaible quizzes
    @GetMapping
    public List<Quiz> getQuiz(){
        return quizService.getAllQuiz();
        // perform validation checks
        // return the services provided by service layer
    }
    @GetMapping("/id/all/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("quizId") Integer quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name/all/{quizName}")
    public Optional<Quiz> getQuiz(@PathVariable("quizName")String quizName){
        return quizService.getQuizByName(quizName);
    }
    @GetMapping("/id/{quizId}")
    public ResponseEntity<QuizDTO> getQuizDTO(@PathVariable("quizId") Integer quizId) {
        QuizDTO quiz = quizService.getQuizDtoById(quizId);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/simple")
    public List<QuizDTO> getAllQuizzes() {
        return quizService.getAllQuizDTOs();
    }


    @PostMapping
    public void insertQuiz(
            @RequestBody AddQuiz request){
        quizService.addQuiz(request);
    }
}
