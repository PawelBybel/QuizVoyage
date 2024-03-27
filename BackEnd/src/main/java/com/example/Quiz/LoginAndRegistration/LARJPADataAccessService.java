package com.example.Quiz.LoginAndRegistration;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa_users")
public class LARJPADataAccessService implements LARDAO {
    private final LARRepository larRepository;

    public LARJPADataAccessService(LARRepository larRepository) {
        this.larRepository = larRepository;
    }

    @Override
    public List<LoginAndRegistration> selectAllUsers() {
        return larRepository.findAll();
    }

    @Override
    public Optional<LoginAndRegistration> selectByEmail(String email) {
        return larRepository.findByEmail(email);
    }

    @Override
    public Optional<LoginAndRegistration> selectByPassword(String password) {
        return larRepository.findByPassword(password);
    }

    @Override
    public Optional<LoginAndRegistration> selectByEmailAndPassword(String email, String password) {
        return larRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public void addUser(LoginAndRegistration loginAndRegistration){
        larRepository.save(loginAndRegistration);
    }
}
