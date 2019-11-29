package com.ywf.srpingbootproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    /**
     * 切入点，其中execution用于使用切面的连接点。
     * 使用方法：execution(方法修饰符(可选) 返回类型 方法名 参数 异常模式(可选)) ，
     */
    @Pointcut("execution(public * com.ywf.srpingbootproject.controller.*.*(..))")
    public void LogAspect() {
    }

    /**
     * 在方法前执行
     *
     * @param joinPoint JoinPoint包含了类名，被切面的方法名，参数等信息。
     */
    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("doBefore");
    }

    /**
     * 在方法后执行
     */
    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("doAfter");
    }

    /**
     * 在方法执行后返回一个结果后执行
     *
     * @param joinPoint
     */
    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("doAfterReturning");
    }

    /**
     * 在方法执行过程中抛出异常的时候执行
     *
     * @param joinPoint
     */
    @AfterThrowing("LogAspect()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        System.out.println("doAfterThrowing");
    }

    /**
     * 环绕通知，就是可以在执行前后都使用，
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("LogAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("doAround");
        // 被切面的方法
        return joinPoint.proceed();
    }
}
