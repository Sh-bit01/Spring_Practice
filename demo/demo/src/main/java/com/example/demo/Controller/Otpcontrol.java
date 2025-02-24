package com.example.demo.Controller;

import com.example.demo.Service.OtpService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/public/otp")
public class Otpcontrol {

    @Autowired
    private OtpService otpService;

    @GetMapping
    public String Hello() {
        Map<String, Object> Response = new HashMap<>();
        return "this is an otp gen and val service";
    }

    @PostMapping("/gen")
    public ResponseEntity<Map<String, Object>> OtpGen(@RequestBody Map<String, String> request) {
        Map<String, Object> Response = new HashMap<>();
        String email = request.get("email");

        Response.put("Otp", otpService.sendOTP(email));

        return ResponseEntity.ok(Response);
    }

    @PostMapping("/val")
    public ResponseEntity<Map<String, Object>> OtpVal(@RequestBody Map<String, String> request) {
        Map<String, Object> Response = new HashMap<>();
        String email = request.get("email");
        String otp = request.get("otp");
        boolean validation = otpService.valOTP(email, otp);

        Response.put("email", email);
        Response.put("Otp", otp);

        if (validation) {
            Response.put("Status", "validation Successful");
        } else {
            Response.put("Status", "validation error");
        }

        return ResponseEntity.ok(Response);
    }

    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getData(HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success");
        response.put("clientIp", request.getRemoteAddr());
        response.put("timestamp", System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }
}
