package com.main.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ControllerAOP {
	
	@Pointcut("execution(* com.*.controller.*.*(..))")
	public void pointcut() {
		// 定義一個pointcut，下面用Annotation標注的通知方法可以公用這個pointcut
	}
	
	@Around("pointcut()")
	public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Controller AoP================================================BEGIN");
		
		Object o = joinPoint.proceed();
		System.out.println("Controller AoP================================================END");	
		
		return o;
	}
	
}
