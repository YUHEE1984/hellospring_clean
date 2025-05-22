package com.example.hellospring_clean.model;

public class Customer {

    private Long id;
    private String name;
    private String email;
    private String memo ="Default memo";

    public Customer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}


