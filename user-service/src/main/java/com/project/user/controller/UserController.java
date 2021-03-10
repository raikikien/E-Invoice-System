package com.project.user.controller;


import com.project.user.ValueObject.ResponseTemplateVO;
import com.project.user.entity.User;
import com.project.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    public ResponseTemplateVO getUserWithInvoice(@PathVariable("id") Long userId){
        log.info("Inside getUserWithInvoice of UserController");
        return userService.getUserWithInvoice(userId);
    }

}
