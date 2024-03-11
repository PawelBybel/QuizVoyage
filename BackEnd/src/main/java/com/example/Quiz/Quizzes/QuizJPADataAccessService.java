package com.example.Quiz.Quizzes;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class QuizJPADataAccessService implements QuizDAO{
    private final QuizRepository quizRepository;



    public QuizJPADataAccessService(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }
    @Override
    public List<Quiz> selectAllQuiz(){
        return quizRepository.findAll();
    }
    @Override
    public boolean existsQuizByName(String name){
        return quizRepository.existsQuizByName(name);
    }

    @Override
    public Optional<Quiz> selectQuizById(Integer id) {
        return quizRepository.findById(id);
    }



    @Override
    public void addQuiz(Quiz quiz) {
    quizRepository.save(quiz);
    }
    @Override
    public boolean existsQuizById(Integer id) {
        return quizRepository.existsQuizById(id);
    }
}

