package com.example.Quiz.Quizzes;

import com.sun.jdi.request.DuplicateRequestException;
import first_spring_code.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
   private final QuizDAO quizDAO;

    public QuizService(QuizDAO quizDAO) {
        this.quizDAO = quizDAO;
    }
    public List<Quiz> getAllQuiz(){
        return quizDAO.selectAllQuiz();
    }
    public Quiz getQuizById(Integer id){
        return quizDAO.selectQuizById(id).orElseThrow(()->new NotFound("Quiz with id [%s] doesn't exist".formatted(id)));
    }
    public QuizDTO getQuizDtoById(Integer quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new NotFound("Quiz with id [%s] doesn't exist".formatted(quizId)));
        return mapQuizToDto(quiz);
    }
    public void addQuiz(AddQuiz addQuiz){
        String name = addQuiz.name();
        if(quizDAO.existsQuizByName(name)){
            throw new DuplicateRequestException("Quiz by that name already exists");
        }
        Quiz quiz = new Quiz(

                addQuiz.name()
        );
        quizDAO.addQuiz(quiz);
    }
    private QuizDTO mapQuizToDto(Quiz quiz) {
        QuizDTO quizDto = new QuizDTO();
        quizDto.setId(quiz.getId());
        quizDto.setName(quiz.getName());
        // Dodaj dodatkowe pola, jeśli są potrzebne

        return quizDto;
    }
    public List<QuizDTO> getAllQuizDTOs() {
        List<Quiz> quizzes = quizDAO.selectAllQuiz();
        return quizzes.stream()
                .map(this::mapQuizToDto)
                .collect(Collectors.toList());
    }

    @Autowired
    private QuizRepository quizRepository;
    public Optional<Quiz> getQuizByName(String name) {
        return quizRepository.findByName(name);
    }

}
