package com.example.Quiz.LoginAndRegistration;

import jakarta.persistence.*;

@Entity

public class LoginAndRegistration {

    @Id
    @SequenceGenerator(
            name = "userId_sequence",
            sequenceName = "userId_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userId_sequence"
    )
    private Integer id;
    @Column(
            nullable = false
    )
    private String email;
    @Column(
            nullable = false
    )
    private String password;
    @Column(
            nullable = false
    )
    private String username;
public LoginAndRegistration(){

}
    public LoginAndRegistration( String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

