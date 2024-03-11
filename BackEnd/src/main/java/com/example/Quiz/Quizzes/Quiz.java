package com.example.Quiz.Quizzes;


import com.example.Quiz.Questions.Questions;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Quiz {
    public Quiz(String name) {
        this.name = name;
    }
    // Konstruktor bezargumentowy
    public Quiz() {
    }
    @Id
    @SequenceGenerator(
            name = "quizId_sequence",
            sequenceName = "quizId_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quizId_sequence"
    )
    private Integer id;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Questions> questions = new ArrayList<>();
    @Column
    private String name;



    ////////////Getters & Setters///////////////
    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
    public void addQuestion(Questions question) {
        this.questions.add(question);
        question.setQuiz(this);
    }

    public Quiz(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) && Objects.equals(name, quiz.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


