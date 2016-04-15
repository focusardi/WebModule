package com.main.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FacadeAOP {
	
	@Pointcut("execution(* com.*.facade.*.*(..))")
	public void pointcut() {
		// 定義一個pointcut，下面用Annotation標注的通知方法可以公用這個pointcut
	}
	
	@Around("pointcut()")
	public Object myAroundAdvice(ProceedingJoinPoint jionpoint) throws Throwable {
		System.out.println("Facade AoP================================================BEGIN");		
		Object o = jionpoint.proceed();
		System.out.println("Facade AoP================================================END");			
		return o;
	}
	
}
