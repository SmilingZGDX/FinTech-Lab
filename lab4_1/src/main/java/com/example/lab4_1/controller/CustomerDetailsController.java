package com.example.lab4_1.controller;

import com.example.lab4_1.entity.CustomerDetails;
import com.example.lab4_1.service.CustomerDetailsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Home");
        return "home";
    }

    @GetMapping("/customers")
    public String getCustomers(
            @RequestParam(defaultValue = "1") int page,
            Model model) {
        int pageSize = 8; // Number of records per page
        Page<CustomerDetails> customerPage = service.getPaginatedCustomers(page - 1, pageSize);

        model.addAttribute("customers", customerPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", customerPage.getTotalPages());
        model.addAttribute("pageTitle", "Customer List");
        return "customers";
    }

    @GetMapping("/allcustomers")
    public String listCustomers(Model model) {
        model.addAttribute("pageTitle", "Customer List");
        model.addAttribute("customers", service.getAllCustomers());
        return "customerdetails";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("pageTitle", "Add Customer");
        model.addAttribute("customerDetails", new CustomerDetails());
        return "customerform";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customerDetails") CustomerDetails customerDetails,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Validation Errors: " + result.getAllErrors());
            return "customerform";
        }
        try {
            service.saveCustomer(customerDetails);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "customerform";
        }
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        service.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully!");
        return "redirect:/customers";
    }
}
