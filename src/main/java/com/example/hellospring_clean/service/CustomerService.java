package com.example.hellospring_clean.service;

import com.example.hellospring_clean.dto.CustomerRequestDto;
import com.example.hellospring_clean.dto.CustomerResponseDto;
import com.example.hellospring_clean.model.Customer;
import com.example.hellospring_clean.repository.CustomerRepository;
import com.example.hellospring_clean.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {


    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {this.repository = repository;}


    public List<CustomerResponseDto> getAllCustomers() {

        List<Customer> customers = repository.findAll();
        return customers.stream()
                .map(CustomerResponseDto::new)
                .collect(Collectors.toList());
    }
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = customerRequestDto.toEntity();
        Customer saved = repository.save(customer);
        return new CustomerResponseDto(saved);
    }
    public CustomerResponseDto getCustomerById(Long id) {

        Customer customer = repository.findById(id)
                .orElseThrow( () -> new CustomerNotFoundException(id));
        return new CustomerResponseDto(customer);
    }

    public void deleteCustomerById(Long id) {

        Customer customer = repository.findById(id)
                .orElseThrow( () -> new CustomerNotFoundException(id));
        repository.delete(customer);
    }

    public CustomerResponseDto updateCustomerById(long id, CustomerRequestDto customerRequestDto) {

        Customer customer = repository.findById(id)
                .orElseThrow( () -> new CustomerNotFoundException(id));
        customer.setName(customerRequestDto.getName());
        customer.setEmail(customerRequestDto.getEmail());
        customer.setMemo(customerRequestDto.getMemo());
        customer.setAge(customerRequestDto.getAge());
        Customer updated = repository.save(customer);
        return new CustomerResponseDto(updated);
    }
}


