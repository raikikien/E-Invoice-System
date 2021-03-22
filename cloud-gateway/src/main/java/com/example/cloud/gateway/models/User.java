package com.example.cloud.gateway.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private String username;
    private String email;
    private String password;
    private boolean active;
    private String role;
    private Long totalmoney;
}
