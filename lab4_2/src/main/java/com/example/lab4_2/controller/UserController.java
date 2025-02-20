package com.example.lab4_2.controller;

import com.example.lab4_2.entity.User;
import com.example.lab4_2.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

	@Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
    	model.addAttribute("pageTitle", "Home");
        return "home";
    }

    @GetMapping("/users")
    public String getUsers(
            @RequestParam(defaultValue = "1") int page,
            Model model) {
        int pageSize = 8; // Number of users per page
        Page<User> userPage = userService.getPaginatedUsers(page - 1, pageSize);

        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("pageTitle", "User List");
        return "users";
    }

    @GetMapping("/allusers")
    public String listUsers(Model model) {
        model.addAttribute("pageTitle", "User List");
        model.addAttribute("users", userService.getAllUsers());
        return "userdetails";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("pageTitle", "Add User");
        model.addAttribute("user", new User());
        return "userform";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Validation Errors: " + result.getAllErrors());
            return "userform";
        }
        try {
            userService.saveUser(user);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "userform";
        }
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/users"; 
    }

}