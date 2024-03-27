package com.example.Quiz.Questions;

import com.example.Quiz.Answers.Answers;
import com.example.Quiz.Quizzes.Quiz;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//Tworzenie Encji Questions
@Entity
public class Questions {

    @Id
    @SequenceGenerator(
            name = "questionsId_sequence",
            sequenceName = "questionsId_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "questionsId_sequence"
    )
    private Integer id;
    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)//przypisanie jednego pytania do wielu odpowiedzi
    private List<Answers> answers = new ArrayList<>();

    @ManyToOne//przypisanie wielu pytan do jednego quizu
    @JoinColumn(name = "quizId")// Kolumna quizId którą joinujemy z PK Quiz
    @JsonIgnoreProperties("questions") //pole questions w obiekcie Quiz przez co nie ma nieskonczonego zapetlenia
    private Quiz quiz;
    @Column(
            nullable = false
    )
    private String question;

    public Questions(String question) {
        this.question = question;
    }
    //Konstruktor bezargumentowy
    public Questions() {
    }

    ////////////Getters & Setters///////////////
    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public Quiz getQuiz() {
        return quiz;
    }


    public void setQuiz(Quiz quiz) {
        if (this.quiz != null) {
            this.quiz.getQuestions().remove(this);
        }


        this.quiz = quiz;

        if (quiz != null) {
            quiz.getQuestions().add(this);
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public void setQuestion(String question) {
        this.question = question;
    }



    public String getQuestion() {
        return question;
    }



    public Questions(Integer id,  String question) {
        this.id = id;


        this.question = question;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, question);
    }
}

