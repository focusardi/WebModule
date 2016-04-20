package com.template.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class TemplateController extends BaseController {
	
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
		//return JSONSerializer.toJSON(templateFacade.getGridData()).toString();
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		data.addAll(templateFacade.getGridData());
				
		HashMap<String, Object> ss = new HashMap<String, Object>();
		ss.put("123", 12333);
		data.add(ss);
		return returnJsonList(data);
		//return returnJsonList(templateFacade.getGridData());
	}
	
	@RequestMapping("/gradleTest")
	public ModelAndView gradleTest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("template/gradleTest");		
	}
	
	@RequestMapping("/grid2")
	public ModelAndView grid2(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("template/grid2", "message", "123");		
	}
	
	@RequestMapping("/grid3")
	public ModelAndView grid3(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("template/grid3", "returnJson", returnJsonList(templateFacade.getGridData()));		
	}
}
