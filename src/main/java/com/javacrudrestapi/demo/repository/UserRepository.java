package com.javacrudrestapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javacrudrestapi.demo.model.User;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user_inventory WHERE username = ?1", nativeQuery = true)
    List<User> getUsername(String username);
}
