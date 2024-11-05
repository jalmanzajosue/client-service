package com.client.client_service.controller;

import com.client.client_service.exception.ResourceNotFoundException;
import com.client.client_service.model.ApiResponse;
import com.client.client_service.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @GetMapping("/test-error")
    public Mono<Void> triggerError() {
        System.out.println("Triggering error...");
        return Mono.error(new ResourceNotFoundException("Test error triggered"));
    }
}