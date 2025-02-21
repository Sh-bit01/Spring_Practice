package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class control {
    @GetMapping
    public String Hello(){
        Map<String, Object> Response = new HashMap<>();
        return "hii";
    }

    @GetMapping("/h")
    public String Hello1(){
        Map<String, Object> Response = new HashMap<>();
        return "hii12";
    }

    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getData(HttpServletRequest request){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        response.put("clientIp", request.getRemoteAddr());
        response.put("timestamp", System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }
}
