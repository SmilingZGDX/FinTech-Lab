package com.example.lab4_3.repository;

import com.example.lab4_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {
}