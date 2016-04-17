package com.template.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.template.facade.TemplateFacade;

import net.sf.json.JSONSerializer;

@Controller
public class TemplateController {
	
	@Autowired
	TemplateFacade templateFacade;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("123333");
		request.setAttribute("TEST", "TESTATT");
		
		templateFacade.doList();
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Hello World, Spring MVC Tutorial</h3></div><br><br>";
		return new ModelAndView("template/welcome", "message", message);
		
		
		
	}
	
	@RequestMapping("/grid")
	public ModelAndView grid(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("template/grid");		
	}
	
	@ResponseBody
	@RequestMapping("/gridData")	
	public String gridData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//JSONSerializer serializer = new JSONSerializer();
		return JSONSerializer.toJSON(templateFacade.getGridData()).toString();
	}
	
	@RequestMapping("/gradleTest")
	public ModelAndView gradleTest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("template/gradleTest");		
	}
}
