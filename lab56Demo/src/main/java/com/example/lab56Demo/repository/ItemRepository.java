package com.example.lab56Demo.repository;
import com.example.lab56Demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ItemRepository extends JpaRepository<Item, Long> {
}