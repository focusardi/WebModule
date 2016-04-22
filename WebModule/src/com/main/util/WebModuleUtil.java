package com.main.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class WebModuleUtil {
	public static String defaultString(Object value, String defaultStr) {
		if (value == null) {
			return defaultStr;
		}

		if (value instanceof Short || value instanceof Integer) {
			return String.valueOf(value);
		} else if (value instanceof BigDecimal) {
			double b = ((BigDecimal) value).setScale(2, BigDecimal.ROUND_UNNECESSARY).doubleValue();

			return String.valueOf(b);
		} else {
			return StringUtils.defaultString((String) value, defaultStr);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> convertRequestDataToMap(HttpServletRequest request) {
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
}
