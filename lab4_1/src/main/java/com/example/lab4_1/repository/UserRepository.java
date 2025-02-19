package com.example.lab4_1.repository;

import com.example.lab4_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/

public interface UserRepository extends JpaRepository<User, Long> {
}