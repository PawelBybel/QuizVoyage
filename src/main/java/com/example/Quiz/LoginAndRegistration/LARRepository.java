package com.example.Quiz.LoginAndRegistration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LARRepository
        extends JpaRepository<LoginAndRegistration, Integer> {
    Optional<LoginAndRegistration> findByEmail(String email);
    Optional<LoginAndRegistration> findByPassword(String password);
    Optional<LoginAndRegistration> findByEmailAndPassword(String email, String password);



}
