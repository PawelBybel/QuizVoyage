package com.example.Quiz.Questions;

import com.example.Quiz.Quizzes.Quiz;
import com.example.Quiz.Quizzes.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
    private final QuestionsDAO questionsDAO;
    private final QuizRepository quizRepository;

    public QuestionsService(QuestionsDAO questionsDAO, QuizRepository quizRepository) {
        this.questionsDAO = questionsDAO;
        this.quizRepository = quizRepository;
    }
    public List<Questions> getAllQuestions(){
        return questionsDAO.selectAllQuestions();
    }
    public List<Questions> getAllQuestionsByQuizId(Integer quizId){
        return questionsDAO.selectAllQuestionsByQuizId(quizId);
    }
    public void addQuestions(AddQuestions addQuestions, Integer quizId){
        String name = addQuestions.name();
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));


        // Zapisanie pytania w bazie danych
        Questions questions = new Questions(name);
        // Ustawienie quizu dla pytania
        questions.setQuiz(quiz);
        questionsDAO.addQuestions(questions);

    }

}
