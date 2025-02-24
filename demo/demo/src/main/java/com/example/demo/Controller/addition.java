package com.example.demo.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/secure")
public class addition {

    @PostMapping("/add")
    public static ResponseEntity<Map<String, Object>> add(@RequestBody Map<String, String> request){
        Map<String, Object> Response = new HashMap<>();
        int num3 = Integer.parseInt(request.get("num1"));
        int num4 = Integer.parseInt(request.get("num2"));

        Response.put("num1",num3);
        Response.put("num2", num4);
        Response.put("Addition",num4+num4);

        return ResponseEntity.ok(Response);
    }

    @PostMapping("/sub")
    public static ResponseEntity<Map<String, Object>> sub(@RequestBody Map<String, String> request){
        Map<String, Object> Response = new HashMap<>();
        int num1 = Integer.parseInt(request.get("num1"));
        int num2 = Integer.parseInt(request.get("num2"));

        Response.put("num1",num1);
        Response.put("num2", num2);
        Response.put("Substraction",num1-num2);

        return ResponseEntity.ok(Response);
    }


}
