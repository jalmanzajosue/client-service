package com.client.client_service.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ApiResponse is a generic wrapper for API responses.
 *
 * @param <T> the type of the data
 */
@Data
@AllArgsConstructor
@Getter
public class ApiResponse<T> {
    private final T data;
    private final ErrorDetails error;
    private final int status;

    public static <T> ApiResponse<T> success(T data, int status) {
        return new ApiResponse<>(data, null, status);
    }

    public static <T> ApiResponse<T> error(ErrorDetails errorDetails, int status) {
        return new ApiResponse<T>(null, errorDetails, status);
    }
}
