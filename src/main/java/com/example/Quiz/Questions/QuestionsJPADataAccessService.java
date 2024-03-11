package com.example.Quiz.Questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jpa_questions")
public class QuestionsJPADataAccessService implements QuestionsDAO {
    private final QuestionsRepository questionsRepository;


    public QuestionsJPADataAccessService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }
    @Override
    public List<Questions> selectAllQuestions(){
        return questionsRepository.findAll();
    }



    @Override
    public List<Questions> selectAllQuestionsByQuizId(Integer quizId){
         return questionsRepository.findAllByQuizId(quizId);
    }
    @Override
    public void addQuestions(Questions questions){
        questionsRepository.save(questions);
    }
}
