package com.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		System.out.println("123333");
		
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("template/welcome", "message", message);
		
		
		
	}
}
