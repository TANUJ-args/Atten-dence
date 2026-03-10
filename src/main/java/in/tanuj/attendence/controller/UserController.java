package in.tanuj.attendence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.tanuj.attendence.model.User;
import in.tanuj.attendence.service.UserService;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public String postCreateUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    
    @PostMapping("/login")
    public String postLoginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }
    
    
    
}
