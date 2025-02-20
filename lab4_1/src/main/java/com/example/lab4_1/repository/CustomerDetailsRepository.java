package com.example.lab4_1.repository;

import com.example.lab4_1.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
    boolean existsByCustomerEmail(String customerEmail);
}
