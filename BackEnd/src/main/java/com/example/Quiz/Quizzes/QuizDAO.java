package com.example.Quiz.Quizzes;

import java.util.List;
import java.util.Optional;

public interface QuizDAO {
    List<Quiz> selectAllQuiz();
    Optional<Quiz> selectQuizById(Integer id);
    boolean existsQuizById(Integer id);
    boolean existsQuizByName(String name);
    void addQuiz(Quiz quiz);
}
