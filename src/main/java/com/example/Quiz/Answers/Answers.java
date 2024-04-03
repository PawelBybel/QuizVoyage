package com.example.Quiz.Answers;

import com.example.Quiz.Questions.Questions;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Answers {
    @Id
    @SequenceGenerator(
            name = "answersId_sequence",
            sequenceName = "answersId_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answersId_sequence"
    )
    private Integer id;
    @Column(name = "is_true")/*(nullable = false)*/
    private boolean isTrue;
    @Column/*(nullable = false)*/
    private String answer;


    @ManyToOne//przypisanie wielu odpowiedzi do jednego pytania
    @JoinColumn(name = "questions_id")
    @JsonIgnoreProperties("answers")
    private Questions questions;

    /////////////Constructors//////////////

    // Konstruktor dla tworzenia nowych odpowiedzi
    public Answers(String answer, boolean isTrue) {
        this.answer = answer;
        this.isTrue = isTrue;
    }

    // Konstruktor bezargumentowy, który może być używany przez Hibernate
    public Answers() {
    }

    // Konstruktor dla edycji istniejącej odpowiedzi
    public Answers(Integer id, boolean isTrue, String answer) {
        this.id = id;
        this.answer = answer;
        this.isTrue = isTrue;
    }
    ////////////Getters & Setters///////////////
    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    public Integer getId() {
        return id;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public String getAnswer() {
        return answer;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, answer);
    }

}
