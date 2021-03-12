package com.project.user.controller;


import com.project.user.ValueObject.ResponseTemplateVO;
import com.project.user.entity.User;
import com.project.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId) {
        log.info("Inside findUserById method of UserController");
        return userService.findUserById(userId);
    }

    @GetMapping("/{id}/invoices")
        public ResponseEntity<List<ResponseTemplateVO>> getUserWithInvoice(@PathVariable("id") Long userId) {
        {
            List<ResponseTemplateVO> vo = new ArrayList<ResponseTemplateVO>();
            if (vo.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vo, HttpStatus.OK);
        }
    }



    @GetMapping("/")
    public ResponseEntity<List<User>> getAllInvoices(@RequestParam(required = false) String username) {
        try {
            List<User> users = new ArrayList<User>();

            if (username == null)
                userService.findAll().forEach(users::add);
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long userId) {
        try {
            userService.deleteByUserId(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
