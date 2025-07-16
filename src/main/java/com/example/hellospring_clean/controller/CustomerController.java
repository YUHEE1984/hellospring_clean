package com.example.hellospring_clean.controller;

import com.example.hellospring_clean.dto.CustomerResponseDto;
import com.example.hellospring_clean.exception.CustomerNotFoundException;
import com.example.hellospring_clean.model.Customer;
import com.example.hellospring_clean.service.CustomerService;
import com.example.hellospring_clean.dto.CustomerRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private final CustomerService service;

    public CustomerController(CustomerService service) {this.service = service;}


    @GetMapping
    public List<CustomerResponseDto> getAllcustomers() {

        return service.getAllCustomers();
    }
    @PostMapping
    public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {

        CustomerResponseDto created = service.addCustomer(customerRequestDto);
        return  new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable Long id) {

        return service.getCustomerById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable long id) {
        service.deleteCustomerById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomerById (@PathVariable long id, @RequestBody @Valid CustomerRequestDto customerRequestDto) {
        CustomerResponseDto updated = service.updateCustomerById(id, customerRequestDto);
        return ResponseEntity.ok(updated);
    }




    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleNotFound(CustomerNotFoundException ex) {

        return ex.getMessage();
    }

}
