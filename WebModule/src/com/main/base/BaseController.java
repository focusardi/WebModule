package com.main.base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.main.util.ConstantUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class BaseController {
	//varargs
	@SuppressWarnings("unchecked")
	public String returnJsonList(List<HashMap<String, Object>> dataList) {
		
		JSONObject returnObject = new JSONObject();
		returnObject.put("pageData", JSONSerializer.toJSON(dataList));

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		Enumeration<String> attrs =  request.getAttributeNames();
		while(attrs.hasMoreElements()) {
			String attrName = attrs.nextElement();
			if (attrName.equals(ConstantUtil.QueryString)) {
				HashMap<String, Object> queryMap = (HashMap<String, Object>) request.getAttribute(attrName);
				JSONObject queryObject = new JSONObject();
				for (String q:queryMap.keySet()) {
					queryObject.put(q, queryMap.get(q));
				}
				returnObject.put(attrName, queryObject);
				
			} else {
				returnObject.put(attrName, request.getAttribute(attrName).toString());
			}
			
		}
		
		returnObject.put("pageDataCount", request.getAttribute("pageDataCountAOP"));
		returnObject.put("pageTotal", request.getAttribute("pageTotalAOP"));
		returnObject.put("pageNumber", request.getAttribute("pageNumberAOP"));
		returnObject.put("pageTotalCount", request.getAttribute("pageTotalCountAOP"));
		
		
		
		
		
		return returnObject.toString();
	}
}
