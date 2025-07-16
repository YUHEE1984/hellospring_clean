package com.example.hellospring_clean.dto;

import com.example.hellospring_clean.model.Customer;
import jakarta.validation.constraints.*;


public class CustomerRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 30, message = "Name must be 1–30 characters")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(regexp = ".+@.+\\..+", message = "Invalid email format")
    private String email;
    @Size(max = 100, message = "Notes should be 100 characters or less")
    private String memo;
    @PositiveOrZero(message = "Age must be greater than or equal to 0")
    private int age;


    public CustomerRequestDto() {
    }
    public CustomerRequestDto(String name, String email, String memo, int age) {
        this.name = name;
        this.email = email;
        this.memo = memo;
        this.age = age;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}
    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }


    @Override
    public String toString() {
        return "CustomerRequestDto{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", memo='" + memo + '\'' +
                ", age='" + age +
                '}';
    }


    public Customer toEntity() {
        return new Customer(name, email, memo, age);
    }
}
