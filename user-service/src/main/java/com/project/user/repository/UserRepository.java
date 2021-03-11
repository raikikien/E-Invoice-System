package com.project.user.repository;

import com.project.user.ValueObject.Invoice;
import com.project.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

   // List<Invoice> findByUsername(String username);
}
