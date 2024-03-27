package com.example.Quiz.LoginAndRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/users")
public class LARController {
    private final LARRepository larRepository;
    private final LARService larService;
@Autowired
    public LARController(LARRepository larRepository, LARService larService) {
        this.larRepository = larRepository;
        this.larService = larService;
    }

    @GetMapping()
    public List<LoginAndRegistration> GetUsers()
    {
    return larService.getAllUsers();
    }
    @PostMapping
    public void insertUser(
            @RequestBody AddUser request){
    larService.addUser(request);
    }
//    @GetMapping("/{email}")
//    public Optional<LoginAndRegistration> GetUserByEmail(@PathVariable("email")String email)
//    {
//        return larService.getUserByEmail(email);
//    }
//    @GetMapping("/{email}/{password}")
//    public Optional<LoginAndRegistration> GetUserByPassword(@PathVariable("password")String password)
//    {
//        return larService.getUserByPassword(password);
//    }
    @GetMapping("/email/{email}/password/{password}")
    public Optional<LoginAndRegistration> GetUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return larService.getUserByEmailAndPassword(email, password);
    }
}
