//package com.example.cloud.gateway.UserAPI;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(name = "USER-SERVICE")
//public interface UserAPI {
//    @GetMapping(value = "/users/{userId}/invoices")
//    public String getInvoicesByUserId(@PathVariable("userId") Long userId);
//    @PostMapping(value = "/users/new")
//    public String saveInvoice(@RequestBody String body);
//    @GetMapping(value = "/users/all")
//    public String getAllUsers();
//    @GetMapping(value = "/users/find/{userId}")
//    public String findByUserId(Long userId);
//
//
//
//}
