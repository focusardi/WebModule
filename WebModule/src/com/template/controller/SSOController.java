package com.template.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.main.base.BaseController;
import com.main.base.BaseFacade;
import com.template.facade.TemplateFacade;

import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("/sso")
public class SSOController extends BaseController {
	
	@Autowired
	TemplateFacade templateFacade;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("123333");
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Hello World, Spring MVC Tutorial</h3></div><br><br>";
		return new ModelAndView("sso/login", "message", message);
		
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(request.getParameter("account"));
		System.out.println(request.getParameter("password"));
		
		Cookie ssoCookie = new Cookie("clutureSSO", "123456");
		response.addCookie(ssoCookie);
		
		return new ModelAndView("redirect:http://127.0.0.1:8080/MOCWEB_RWD/CHCSEC/portal/FrontMember/B0106MAction");
		
	}
	
	
}