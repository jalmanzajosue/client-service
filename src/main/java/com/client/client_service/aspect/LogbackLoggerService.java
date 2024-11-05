package com.client.client_service.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogbackLoggerService implements ILoggerService {
    private final Logger logger = LoggerFactory.getLogger(LogbackLoggerService.class);

    @Override
    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    @Override
    public void error(String message, Object... args) {
        logger.error(message, args);
    }
}
