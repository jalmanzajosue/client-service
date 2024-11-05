package com.client.client_service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Autowired
    private  ILoggerService loggerService;

    @Pointcut("execution(* com.client.client_service.service..*(..))")
    public void applicationServicePointcut() {

    }

    @Before("applicationServicePointcut()")
    public void logBeforeMethod(ProceedingJoinPoint joinPoint) {
        loggerService.info("Ejecutando método: {} con argumentos: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "applicationServicePointcut()", returning = "result")
    public void logAfterMethodReturn(Object result) {
        loggerService.info("Método ejecutado exitosamente, resultado: {}", result);
    }

    @AfterThrowing(pointcut = "applicationServicePointcut()", throwing = "exception")
    public void logAfterMethodThrowing(Exception exception) {
        loggerService.error("Excepción lanzada en método: {}", exception.getMessage(), exception);
    }
}
