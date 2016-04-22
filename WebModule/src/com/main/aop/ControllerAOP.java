package com.main.aop;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.main.util.ConstantUtil;
import com.main.util.WebModuleUtil;

@Aspect
public class ControllerAOP {
	
	@Pointcut("execution(* com.*.controller.*.*(..))")
	public void pointcut() {
		// 定義一個pointcut，下面用Annotation標注的通知方法可以公用這個pointcut
	}
	
	@Around("pointcut()")
	public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Controller AoP================================================BEGIN");
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		//儲存執行參數
		HashMap<String, Object> queryStringMap = WebModuleUtil.convertRequestDataToMap(request);
		request.setAttribute(ConstantUtil.QueryString, queryStringMap);
		
		Object o = joinPoint.proceed();
		System.out.println("Controller AoP================================================END");	
		
		return o;
	}
	
}
