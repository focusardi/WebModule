package com.main.base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class BaseController {
	//varargs
	public String returnJsonList(List<HashMap<String, Object>> dataList) {
		
		JSONObject returnObject = new JSONObject();
		returnObject.put("pageData", JSONSerializer.toJSON(dataList));

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		Enumeration<String> attrs =  request.getAttributeNames();
		while(attrs.hasMoreElements()) {
			String attrName = attrs.nextElement();			
			returnObject.put(attrName, request.getAttribute(attrName).toString());
		}
		
		returnObject.put("pageDataCount", request.getAttribute("pageDataCountAOP"));
		returnObject.put("pageTotal", request.getAttribute("pageTotalAOP"));
		returnObject.put("pageNumber", request.getAttribute("pageNumberAOP"));
		returnObject.put("pageTotalCount", request.getAttribute("pageTotalCountAOP"));
		
		
		
		
		
		return returnObject.toString();
	}
}
