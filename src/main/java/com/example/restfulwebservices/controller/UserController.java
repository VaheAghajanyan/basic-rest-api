package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.exceptions.UserNotFoundException;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return this.userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = this.userDaoService.findOne(id);

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("id:" + id);
        }

        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        this.userDaoService.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User savedUser = this.userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
