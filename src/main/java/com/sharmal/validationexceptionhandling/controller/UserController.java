package com.sharmal.validationexceptionhandling.controller;

import com.sharmal.validationexceptionhandling.dto.UserRequest;
import com.sharmal.validationexceptionhandling.exception.UserNotFoundException;
import com.sharmal.validationexceptionhandling.model.User;
import com.sharmal.validationexceptionhandling.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUses() {
//        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }
}
