package com.project.user.controller;


import com.project.user.entity.User;
import com.project.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/users/new")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users/update/{userId}")
    public ResponseEntity<User> updateTutorial(@PathVariable("userId") Long userId, @RequestBody User user) {
        Optional<User> userData = Optional.ofNullable(userService.findByUserId(userId));

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setUsername(user.getUsername());
            _user.setEmail(user.getEmail());
            _user.setPassword(user.getPassword());
            _user.setActive(user.isActive());
            return new ResponseEntity<>(userService.saveUser(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/find/{userId}")
    public ResponseEntity<User>findByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.findByUserId(userId));
    }

    @GetMapping("/users/{userId}/invoices")
    public ResponseEntity<String> findInvoiceByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.findInvoiceByUserId(userId));
    }

    @GetMapping("/users/getall")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.findAll();
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long userId) {
        try {
            userService.deleteByUserId(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
