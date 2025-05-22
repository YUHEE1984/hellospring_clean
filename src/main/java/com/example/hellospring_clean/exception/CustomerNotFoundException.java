package com.example.hellospring_clean.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Can't find customers with that ID: " + id);
    }
}
