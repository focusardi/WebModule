package com.main.facade.base;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.main.db.base.DBAccess;
import com.main.util.WebModuleUtil;

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
		
		if (getParameter("pageNum") != null && getParameter("pageSize") != null) {
			
			
			if ("".equals(getParameter("pageNum"))) {
				setPageNum(0);
			} else {
				setPageNum(Integer.parseInt(getParameter("pageNum")));
			}
			if ("".equals(getParameter("pageSize"))) {
				setPageSize(0);
			} else {
				setPageSize(Integer.parseInt(getParameter("pageSize")));
			}
			
		} else {
			setPageNum(0);
			setPageSize(0);
		}		
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
			dataMap = (HashMap<String, Object>)request.getAttribute("multiReadMap");
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
		
		Object value = this.requestMap.get(name);
		if (value == null) {
			return null;
		}

		if (value instanceof Short || value instanceof Integer) {
			return String.valueOf(value);
		} else if (value instanceof BigDecimal) {
			double b = ((BigDecimal) value).setScale(2, BigDecimal.ROUND_UNNECESSARY).doubleValue();

			return String.valueOf(b);
		} else {
			return StringUtils.defaultString((String) value, "");
		}
		
	}
}
