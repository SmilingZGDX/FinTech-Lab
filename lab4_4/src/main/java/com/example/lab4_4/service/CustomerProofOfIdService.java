package com.example.lab4_4.service;

import com.example.lab4_4.entity.CustomerProofOfId;
import com.example.lab4_4.repository.CustomerProofOfIdRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProofOfIdService {

    @Autowired
    private CustomerProofOfIdRepository repository;

    public CustomerProofOfIdService(CustomerProofOfIdRepository repository) {
        this.repository = repository;
    }

    public CustomerProofOfId getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Proof of ID not found"));
    }

    public Page<CustomerProofOfId> getPaginatedRecords(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize));
    }

    public List<CustomerProofOfId> getAllRecords() {
        return repository.findAll();
    }

    public void saveRecord(@Valid CustomerProofOfId record) {
        if (repository.existsByProofIdType(record.getProofIdType())) {
            throw new RuntimeException("Proof of ID Type already exists");
        }
        repository.save(record);
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}
