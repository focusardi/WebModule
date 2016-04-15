package com.main.facade.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.db.base.DBAccess;

public class BaseFacade {
	
	@Autowired
	protected DBAccess objDB;
	
	protected HttpServletRequest request;
	
	protected int pageNum;
	
	protected int pageSize;
	
	protected HashMap<String, Object> requestMap;

	public void setRequest(HttpServletRequest request) {
		this.request = request;		
		setRequestMap(convertRequestDataToMap(this.request));		
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setRequestMap(HashMap<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, Object> convertRequestDataToMap(HttpServletRequest request) {
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		
		if (request.getMethod().equals("POST") && request.getContentType().startsWith("multipart/form-data")) {
			//System.out.println(request.getAttribute("acerVMap"));
			
			dataMap = (HashMap<String, Object>)request.getAttribute("acerVMap");
		} else {
			Map<String, String[]> requestMap = request.getParameterMap();			
			
			for (String key : requestMap.keySet()) {
				if (key.endsWith("[]")) {
					dataMap.put(key.replace("[]", ""), requestMap.get(key));
				} else {
					dataMap.put(key, requestMap.get(key)[0]);
				}
			}
			
		}		
		return dataMap;
	}
	
	public String getParameter(String name) {
		return this.requestMap.get(name).toString();
	}
}
