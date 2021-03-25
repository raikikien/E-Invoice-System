//package com.example.cloud.gateway.controller;
//
//import com.example.cloud.gateway.models.User;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//public class GatewayController {
//
//
//    @GetMapping("/")
//    public String main(Model model) {
//        return "index";
//    }
//
//    @PostMapping("/users/new")
//    public String showUserRegisterPage(Model model)
//    {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "new_user";
//    }
//
//
//}
