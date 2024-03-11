package com.example.Quiz.Answers;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jpa_answers")
public class AnswersJPADataService implements AnswersDAO {
    private final AnswersRepository answersRepository;

    public AnswersJPADataService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    public void addAnswers(Answers answers) {
        answersRepository.save(answers);

    }

    @Override
    public List<Answers> selectAllAnswers() {
        return answersRepository.findAll();
    }

}
