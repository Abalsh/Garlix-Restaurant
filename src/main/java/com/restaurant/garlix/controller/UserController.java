package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.User;
import com.restaurant.garlix.exception.UserNotFoundException;
import com.restaurant.garlix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "id", id));
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PatchMapping("/{id}")
    public User modifyUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "uniid", id));

        user.setUserName(userDetails.getUserName());
        user.setUniId(userDetails.getUniId());

        User modifiedUser = userRepository.save(user);
        return modifiedUser;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();

    }
}