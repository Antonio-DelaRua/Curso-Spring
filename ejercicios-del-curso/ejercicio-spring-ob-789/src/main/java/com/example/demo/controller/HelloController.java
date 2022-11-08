package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hola")
    public String holamundo() {

        return "Hola mundo, que tal , codeando?";
    }

}