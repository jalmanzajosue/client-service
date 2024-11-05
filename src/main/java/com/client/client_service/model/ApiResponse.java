package com.client.client_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private  T data;
    private  ErrorDetails error;
    private  int status;

    public static <T> ApiResponse<T> success(T data, int status) {
        return new ApiResponse<>(data, null, status);
    }

    public static <T> ApiResponse<T> error(ErrorDetails errorDetails, int status) {
        return new ApiResponse<>(null, errorDetails, status);
    }
}
