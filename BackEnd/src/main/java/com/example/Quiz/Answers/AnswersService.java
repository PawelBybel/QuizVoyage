package com.example.Quiz.Answers;

import com.example.Quiz.Questions.Questions;
import com.example.Quiz.Questions.QuestionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {
    private final AnswersDAO answersDAO;
    private final QuestionsRepository questionsRepository;

    public AnswersService(AnswersDAO answersDAO, QuestionsRepository questionsRepository)
    {
        this.answersDAO = answersDAO;
        this.questionsRepository = questionsRepository;
    }
    public void addAnswers(AddAnswers addAnswers,Integer questionsId)
    {
        String answer = addAnswers.answer();
        boolean isTrue = addAnswers.isTrue();
        Questions questions = questionsRepository.findById(questionsId).orElseThrow(() -> new RuntimeException("Questions not found"));
        // Sprawdzanie, czy pytanie ma już 4 odpowiedzi
        if (questions.getAnswers().size() >= 4) {
            throw new RuntimeException("Cannot add more than 4 answers to a question");
        }

        Answers answers = new Answers(answer,isTrue);
        answers.setQuestions(questions);
        answersDAO.addAnswers(answers);
    }
    public List<Answers> getAllAnswers(){
        return answersDAO.selectAllAnswers();
    }
}
