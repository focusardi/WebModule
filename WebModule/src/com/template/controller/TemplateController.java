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
		return new ModelAndView("template/grid3", "data", returnJsonList(templateFacade.getGridData()));		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/mobileData", produces = "text/plain;charset=UTF-8")	
	public String mobileData(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String returnString = "{ \"HEADER\": { \"LEFT\": \"上一頁\", \"LEFT_URL\": \"back\", \"HEADER_NAME\": \"授課大綱\" },"
				+ " \"MENU\": [ { \"NAME\": \"104學年度下學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1042\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"104學年度上學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1041\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"103學年度下學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1032\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"103學年度上學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1031\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"102學年度下學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1022\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"102學年度上學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1021\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"101學年度下學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1012\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"101學年度上學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1011\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"100學年度下學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1002\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" }, { \"NAME\": \"100學年度上學期\", \"URL\": \"Icon4.aspx?p=P3&ayearsms=1001\", \"BACKGROUND_COLOR\": \"#1490C1\", \"TEXT_COLOR\": \"#FFFFFF\" } ], \"SUBJECT\": { \"NAME\": \"請選擇學年期\", \"TEXT_COLOR\": \"#34ADDC\", \"BACKGROUND_COLOR\": \"#FFFFFF\", \"BORDER_COLOR\": \"#34ADDC\" } }";
		return returnString;
	}
	
}
