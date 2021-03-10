package com.project.user.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity (name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="userId")
    private Long userId;
    @Column (name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    private Long id;
}
