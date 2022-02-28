package com.spring.api.controller;

import com.spring.api.domain.User;
import com.spring.api.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{name}")
    public User getUserByName(@PathVariable String name){
        Optional<User> optUser = userRepository.findByUsername(name);
        return optUser.orElse(null);
    }

    @PatchMapping("/users/{name}")
    public User updateUser(@PathVariable String name, @RequestBody User user){
        Optional<User> optUser = userRepository.findByUsername(name);

        if (optUser.isPresent()){
            User existUser = optUser.get();
            existUser.setCity(user.getCity());
            existUser.setState(user.getState());
            existUser.setZipcode(user.getZipcode());
            existUser.setIsDairyAllergies(user.getIsDairyAllergies());
            existUser.setIsEggAllergies(user.getIsEggAllergies());
            existUser.setIsPeanutAllergies(user.getIsPeanutAllergies());

            return userRepository.save(existUser);
        }

        return null;
    }
}
