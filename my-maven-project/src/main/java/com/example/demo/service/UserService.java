package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    } 

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    } 

    public int updateUser(Long id, String name){
        return userRepository.updateUser(id,name);
    }

    public int deleteById(Long id){
        return userRepository.deletebyId(id);
    }
}