package com.example.bai_1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MainAspect {
    private long requestsToServer = 0;

    @Pointcut("within(com.example.bai_1.controller.*)")
    public void countRequestsToServer() {
    }

    @Before("countRequestsToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.requestsToServer++;
        System.out.println("The request of requests to server: " + this.requestsToServer);
    }
}
