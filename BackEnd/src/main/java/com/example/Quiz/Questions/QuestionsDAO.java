package com.example.Quiz.Questions;

import java.util.List;

public interface QuestionsDAO {
    List<Questions> selectAllQuestions();
    List<Questions> selectAllQuestionsByQuizId(Integer quizId);

    void addQuestions(Questions questions);
}
