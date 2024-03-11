package com.example.Quiz.Answers;

import java.util.List;

public interface AnswersDAO {
    void addAnswers(Answers answers);
    List<Answers> selectAllAnswers();
}
