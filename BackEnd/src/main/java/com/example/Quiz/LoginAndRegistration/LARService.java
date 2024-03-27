package com.example.Quiz.LoginAndRegistration;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LARService {
    private final LARDAO larDAO;
    public LARService(LARDAO larDAO ){
        this.larDAO = larDAO;
    }
    public List<LoginAndRegistration> getAllUsers(){
        return larDAO.selectAllUsers();
    }
    public void addUser(AddUser addUser){
//        String username = addUser.username();
//        String password = addUser.password();
//        String email = addUser.email();
       LoginAndRegistration loginAndRegistration = new LoginAndRegistration(
               addUser.email(),
               addUser.password(),
               addUser.username()
       );
       larDAO.addUser(loginAndRegistration);
    }
    public Optional<LoginAndRegistration> getUserByEmail(String email){
        return larDAO.selectByEmail(email);
    }
    public Optional<LoginAndRegistration> getUserByPassword(String password){
        return larDAO.selectByPassword(password);
    }
    public Optional<LoginAndRegistration> getUserByEmailAndPassword(String email,String password){
        return larDAO.selectByEmailAndPassword(email, password);
    }


}
