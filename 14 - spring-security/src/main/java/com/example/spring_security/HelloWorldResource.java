package com.example.spring_security;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloWorldResource {
    
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World v2289";
    }
}
