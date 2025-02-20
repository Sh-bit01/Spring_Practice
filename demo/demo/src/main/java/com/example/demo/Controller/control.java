package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {
    @GetMapping
    public String Hello(){
        return "hii";
    }

    @GetMapping("/h")
    public String Hello1(){
        return "hii12";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
