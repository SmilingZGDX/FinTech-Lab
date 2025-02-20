package com.example.lab4_1.service;

import com.example.lab4_1.entity.CustomerDetails;
import com.example.lab4_1.repository.CustomerDetailsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsService {

    @Autowired
    private CustomerDetailsRepository repository;

    public CustomerDetailsService(CustomerDetailsRepository repository) {
        this.repository = repository;
    }

    public CustomerDetails getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Page<CustomerDetails> getPaginatedCustomers(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize));
    }

    public List<CustomerDetails> getAllCustomers() {
        return repository.findAll();
    }

    public void saveCustomer(@Valid CustomerDetails customer) {
        if (repository.existsByCustomerEmail(customer.getCustomerEmail())) {
            throw new RuntimeException("Customer with this email already exists");
        }
        repository.save(customer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
