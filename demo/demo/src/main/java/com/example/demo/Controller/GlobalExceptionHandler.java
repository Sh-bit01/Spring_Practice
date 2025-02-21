package com.example.demo.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GlobalExceptionHandler implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        Map<String, Object> errorResponse = new HashMap<>();

        // Fetch error status from request
        Object statusCode = request.getAttribute("javax.servlet.error.status_code");
        HttpStatus status = (statusCode != null) ? HttpStatus.valueOf(Integer.parseInt(statusCode.toString())) : HttpStatus.INTERNAL_SERVER_ERROR;

        // Fetch error message from request
        Object errorMessage = request.getAttribute("javax.servlet.error.message");

        // Build detailed error response
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", status.value());
        errorResponse.put("error", status.getReasonPhrase());
        errorResponse.put("message", (errorMessage != null) ? errorMessage.toString() : "Unexpected error occurred.");
        //errorResponse.put("path", request.getRequestURI());
        errorResponse.put("suggestion", "Please check the request and try again. If the issue persists, contact support.");

        return new ResponseEntity<>(errorResponse, status);
    }
}
