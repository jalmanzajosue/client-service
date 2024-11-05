package com.client.client_service.aspect;

public interface ILoggerService {
    void info(String message, Object... args);
    void error(String message, Object... args);
}
