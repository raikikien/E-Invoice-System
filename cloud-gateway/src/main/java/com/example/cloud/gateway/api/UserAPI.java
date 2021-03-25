package com.example.cloud.gateway.api;

import com.example.cloud.gateway.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "USER-SERVICE")
public interface UserAPI {
    @GetMapping(value = "/users/{userId}/invoices")
    public ResponseEntity<User> getInvoicesByUserId(@PathVariable("userId") Long userId);
    @PostMapping(value = "/users/new")
    public ResponseEntity<User> saveInvoice(@RequestBody String body);
    @GetMapping(value = "/users/all")
    public ResponseEntity<User> getAllUsers();
    @GetMapping(value = "/users/find/{userId}")
    public ResponseEntity<User> findByUserId(Long userId);
    @PutMapping("/users/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user);
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long userId);


}
