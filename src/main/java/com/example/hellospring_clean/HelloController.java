package com.example.hellospring_clean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "안녕! 나의 첫 Spring API 🎉";
    }
}

