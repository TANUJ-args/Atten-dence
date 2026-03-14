package in.tanuj.attendence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.tanuj.attendence.model.User;
import in.tanuj.attendence.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String CreateUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    
    @PostMapping("/login")
    public String LoginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }
    
    
    
}
