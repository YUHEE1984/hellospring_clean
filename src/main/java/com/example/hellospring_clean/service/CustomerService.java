package com.example.hellospring_clean.service;

import com.example.hellospring_clean.model.Customer;
import com.example.hellospring_clean.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

}
