package com.template.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.main.base.BaseController;
import com.main.base.BaseFacade;
import com.main.util.ConstantUtil;
import com.template.facade.SSOFacade;
import com.template.facade.TemplateFacade;

import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("/sso")
public class SSOController extends BaseController {
	
	@Autowired
	SSOFacade sSOFacade;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(@CookieValue(value = ConstantUtil.SSOCOOKIE,required = false) String clutureSSOCookie, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(">> " + clutureSSOCookie);
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Hello World, Spring MVC Tutorial</h3></div><br><br>";
		return new ModelAndView("sso/login", "message", message);
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@CookieValue(value = ConstantUtil.SSOCOOKIE,required = false) String clutureSSOCookie, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		if (sSOFacade.validAccountPassword()) {
			//登入成功
			String authCode = sSOFacade.getAuthCode();
			
			String cookie = sSOFacade.getNewSSOCookie();
			
			Cookie ssoCookie = new Cookie(ConstantUtil.SSOCOOKIE, cookie);		
			response.addCookie(ssoCookie);
			
			return new ModelAndView("redirect:http://127.0.0.1:8080/MOCWEB_RWD/CHCSEC/portal/FrontMember/B0106MAction?mcAuthCode=" + authCode);
		} else {
			//登入失敗
			return new ModelAndView("sso/login", "message", "帳號密碼錯誤");
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getToken", produces = "application/json;charset=UTF-8")	
	public String getToken(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		//System.out.println("getToken mcAuthCode:" + request.getParameter("mcAuthCode"));
		
		String returnString = "{\"mcAuthToken\":\"AUTHTTTTOKEN" + request.getParameter("mcAuthCode") + "\"}";
				
		return returnString;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getMemberInfo", produces = "application/json;charset=UTF-8")	
	public String getMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		//System.out.println("getToken mcAuthCode:" + request.getParameter("mcAuthCode"));
		
		String returnString = "{\"idno\":\"A127385478\"}";
				
		return returnString;
	}
	
	@RequestMapping("/ssoCheck")
	public ModelAndView ssoCheck(@CookieValue(value = ConstantUtil.SSOCOOKIE,required = false) String clutureSSOCookie, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("ssoCheck:>" + clutureSSOCookie);
		
		return new ModelAndView("sso/ssoCheck");
		
	}
	
}
