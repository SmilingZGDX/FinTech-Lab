package com.example.lab4_3.service;



import com.example.lab4_3.entity.User;
import com.example.lab4_3.repository.UserRepository;
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

    /**
     * Retrieves a paginated list of users.
     *
     * @param page the page number (0-based index)
     * @param pageSize the number of users per page
     * @return a Page object containing users
     */
    public Page<User> getPaginatedUsers(int page, int pageSize) {
        return userRepository.findAll(PageRequest.of(page, pageSize));
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Saves a user.
     *
     * @param user the user entity to be saved
     */
    public void saveUser(@Valid User user) {
        userRepository.save(user);
    }
}