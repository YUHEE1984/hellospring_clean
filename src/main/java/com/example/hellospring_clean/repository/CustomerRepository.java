package com.example.hellospring_clean.repository;

import com.example.hellospring_clean.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public  List<Customer> findAll() {
        return customers;
    }

    public void save(Customer customer) {
        customers.add(customer);
    }


    public Optional<Customer> findById(Long id) {

        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }
}

