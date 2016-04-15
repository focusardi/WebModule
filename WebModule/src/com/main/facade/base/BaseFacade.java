package com.main.facade.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.db.base.DBAccess;

public class BaseFacade {
	
	@Autowired
	protected DBAccess objDB;
	
	protected HttpServletRequest request;
	
	//protected HttpServletResponse response;

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

//	public void setResponse(HttpServletResponse response) {
//		this.response = response;
//	}
	
	
}
