package com.example.Quiz.LoginAndRegistration;

import java.util.List;
import java.util.Optional;

public interface LARDAO {
    List<LoginAndRegistration> selectAllUsers();
//    Optional<LoginAndRegistration> findByEmail(String email);
//    Optional<LoginAndRegistration> findByPassword(String password);

    Optional<LoginAndRegistration> selectByEmail(String email);

    Optional<LoginAndRegistration> selectByPassword(String password);
    Optional<LoginAndRegistration> selectByEmailAndPassword(String email, String password);

    void addUser(LoginAndRegistration loginAndRegistration);

}
