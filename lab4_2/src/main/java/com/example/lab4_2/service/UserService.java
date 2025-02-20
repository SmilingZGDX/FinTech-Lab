package com.example.lab4_2.service;

import com.example.lab4_2.entity.User;
import com.example.lab4_2.repository.UserRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Page<User> getPaginatedUsers(int page, int pageSize) {
        return userRepository.findAll(PageRequest.of(page, pageSize));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(@Valid User user) {
    	if (userRepository.existsByItem(user.getItem())) {
            throw new RuntimeException("Item already exists");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}