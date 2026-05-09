package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        if(userService.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        return userService.createUser(user);
    }
}
