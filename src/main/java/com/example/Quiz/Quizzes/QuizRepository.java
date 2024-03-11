package com.example.Quiz.Quizzes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository
    extends JpaRepository<Quiz, Integer>{
    Optional<Quiz> findByName(String name);
    boolean existsQuizById(Integer id);
    boolean existsQuizByName(String name);


}
