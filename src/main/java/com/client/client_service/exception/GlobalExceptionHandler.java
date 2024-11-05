package com.client.client_service.exception;

import com.client.client_service.model.ApiResponse;
import com.client.client_service.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Mono<ResponseEntity<ApiResponse<ErrorDetails>>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                "Resource not found"
        );
        ApiResponse<ErrorDetails> response = ApiResponse.error(errorDetails,404);
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(response));
    }

    @ExceptionHandler(Exception.class) // Catch-all for any other exceptions
    public Mono<ResponseEntity<ApiResponse<Void>>> handleGlobalException(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                "Internal Server Error: " + ex.getMessage(),
                "An unexpected error occurred"
        );
        ApiResponse<Void> response = ApiResponse.error(errorDetails,500);
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response));
    }
}