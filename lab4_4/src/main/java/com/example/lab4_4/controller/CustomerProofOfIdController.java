package com.example.lab4_4.controller;

import com.example.lab4_4.entity.CustomerProofOfId;
import com.example.lab4_4.service.CustomerProofOfIdService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerProofOfIdController {

    @Autowired
    private CustomerProofOfIdService service;

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
        Page<CustomerProofOfId> customerPage = service.getPaginatedRecords(page - 1, pageSize);

        model.addAttribute("customers", customerPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", customerPage.getTotalPages());
        model.addAttribute("pageTitle", "Customer Proof of ID List");
        return "customers";
    }

    @GetMapping("/allcustomers")
    public String listCustomers(Model model) {
        model.addAttribute("pageTitle", "Customer Proof of ID List");
        model.addAttribute("customers", service.getAllRecords());
        return "customerdetails";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("pageTitle", "Add Customer Proof of ID");
        model.addAttribute("customerProofOfId", new CustomerProofOfId());
        return "customerform";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customerProofOfId") CustomerProofOfId customerProofOfId,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Validation Errors: " + result.getAllErrors());
            return "customerform";
        }
        try {
            service.saveRecord(customerProofOfId);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "customerform";
        }
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        service.deleteRecord(id);
        redirectAttributes.addFlashAttribute("message", "Customer Proof of ID deleted successfully!");
        return "redirect:/customers";
    }
}
