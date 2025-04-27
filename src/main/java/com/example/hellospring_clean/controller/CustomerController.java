package com.example.hellospring_clean.controller;

import com.example.hellospring_clean.model.Customer;
import com.example.hellospring_clean.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getAllcustomers() {
        return service.getAllCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {service.addCustomer(customer);
    }

}
