package com.main.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.PageInfo;
import com.main.base.BaseFacade;

import net.sf.json.JSONSerializer;


@Aspect
public class DBAccessPageListAOP {
	
	@Pointcut("execution(* com.main.base.DBAccess.selectPageList(..))")
	public void pointcut() {
		// 定義一個pointcut，下面用Annotation標注的通知方法可以公用這個pointcut
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Around("pointcut()")
	public Object myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("selectPageList AoP================================================BEGIN");
		
		Object o = joinPoint.proceed();
		PageInfo page = new PageInfo((List) o);
		System.out.println("->>>" + page.getPageSize());
		System.out.println("->>>" + page.getTotal());
		System.out.println("->>>" + page.getLastPage());
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();		
		request.setAttribute("pageDataCountAOP", page.getPageSize());
		request.setAttribute("pageTotalCountAOP", page.getTotal());
		request.setAttribute("pageTotalAOP", page.getNavigatePages() + 1);
		request.setAttribute("pageNumberAOP", page.getPageNum());
		int[] a = page.getNavigatepageNums();
		int b = page.getNavigatePages();
		int c = page.getLastPage();
		
		System.out.println("selectPageList AoP================================================END");			
		return o;
	}

	
}
