package com.example.hellospring_clean.dto;

import com.example.hellospring_clean.model.Customer;

public class CustomerResponseDto {


    private Long id;
    private String name;
    private String email;


    public CustomerResponseDto(){}

    public CustomerResponseDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }


    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "CustomerResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
