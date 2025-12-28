package com.springsec.spring_sec_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/api/v1")
public class SecurityTestController {

    @GetMapping("/hello")
    public String greet(){
        return "Welcome to testing route!";
    }
}
