package com.example.lab4_4.repository;

import com.example.lab4_4.entity.CustomerProofOfId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProofOfIdRepository extends JpaRepository<CustomerProofOfId, Long> {
    boolean existsByProofIdType(String proofIdType);
}
