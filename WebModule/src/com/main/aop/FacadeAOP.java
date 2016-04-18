package com.main.aop;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.main.base.BaseFacade;


@Aspect
public class FacadeAOP {
	
	@Pointcut("execution(* com.*.facade.*.*(..))")
	public void pointcut() {
		// 定義一個pointcut，下面用Annotation標注的通知方法可以公用這個pointcut
	}
	
	@Around("pointcut()")
	public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Facade AoP================================================BEGIN");
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		//System.out.println(request.getParameter("pageNum"));
		
//		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//		Method method = signature.getMethod();
//		if (method.getDeclaringClass().isInterface()) {
//	        try {
//	            method= joinPoint.getTarget().getClass().getDeclaredMethod(joinPoint.getSignature().getName(),
//	                    method.getParameterTypes());
//	        } catch (final SecurityException exception) {
//	            //...
//	        } catch (final NoSuchMethodException exception) {
//	            //...                
//	        }
//	    }
		
		
		BaseFacade target = (BaseFacade)joinPoint.getTarget();
		target.setRequest(request);
		
		Object o = joinPoint.proceed();		
		System.out.println("Facade AoP================================================END");			
		return o;
	}
	
}
