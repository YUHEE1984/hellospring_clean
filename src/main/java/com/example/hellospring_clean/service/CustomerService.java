package com.example.hellospring_clean.service;

import com.example.hellospring_clean.model.Customer;
import com.example.hellospring_clean.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.example.hellospring_clean.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

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


    public Customer getCustomerById(Long id) {

        Optional<Customer> result = repository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }
}


