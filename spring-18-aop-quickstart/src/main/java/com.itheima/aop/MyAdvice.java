package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(public int com.itheima.dao.BookDao.select())")
    private void pt(){}

    //@Before("pt()")
    public void before(){
        System.out.println("before...");
    }

    //@After("pt()")
    public void after(){
        System.out.println("after...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before...");
        Object proceed = pjp.proceed();
        System.out.println("around after...");
        return proceed;
    }

    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

}
