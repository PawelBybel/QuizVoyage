package com.example.Quiz.Questions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository
                    extends JpaRepository<Questions,Integer>
{
    List<Questions> findAllByQuizId(Integer quizId);

}
