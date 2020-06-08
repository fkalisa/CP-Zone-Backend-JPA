package com.example.demo.JPAbackendZone.controller;

import com.example.demo.JPAbackendZone.DAO.User;
import com.example.demo.JPAbackendZone.repository.UserRepository;
import com.example.demo.JPAbackendZone.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    @PostMapping("/user")
    public void insertUser(@PathVariable UserRequest userRequest) {
        User user = new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getAge());
        userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public void updatrUser(@PathVariable Integer id, @PathVariable UserRequest userRequest) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setAge(userRequest.getAge());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            userRepository.save(user);
        }
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
