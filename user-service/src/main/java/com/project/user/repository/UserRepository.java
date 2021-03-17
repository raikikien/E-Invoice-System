package com.project.user.repository;

import com.project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
    @Query("SELECT e FROM user e WHERE e.username = :username")
    public User getUserByUsername(@Param("username") String username);
}
