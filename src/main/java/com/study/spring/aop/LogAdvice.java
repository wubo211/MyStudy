/*
package com.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

*/
/**
 * @Description：
 * @Author： wub
 * @Date： 2020/1/9 11:16
 **//*

@Aspect
@Component
public class LogAdvice {

    @Before("com.study.spring.aop.SonAspect.addLog()")
    public void before(){
        System.out.println("LogAdvice before advice");
    }

    @After("com.study.spring.aop.SonAspect.addLog()")
    public void after(){
        System.out.println("LogAdvice after advice");
    }

    @Around(value = "com.study.spring.aop.SonAspect.addLog()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("LogAdvice around before advice ");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("LogAdvice around after advice ");
    }

}
*/
