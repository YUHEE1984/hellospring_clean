package com.example.hellospring_clean.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String memo ="Default memo";
    private int age;


    public Customer() {}
    public Customer(String name, String email, String memo, int age) {
        this.name = name;
        this.email = email;
        this.memo = memo;
        this.age = age;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getMemo() {return memo;}
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", memo='" + memo + '\'' +
                ", age='" + age +
                '}';
    }
}


