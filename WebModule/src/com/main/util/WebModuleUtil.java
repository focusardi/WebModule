package com.main.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	public static String getCurrentTWTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		
		return convertTWDate(dateFormat.format(date), "yyyyMMddHHmmssSSS", "yyyMMddHHmmssSSS");
	}

	public static String getCurrentTWDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();

		return convertTWDate(dateFormat.format(date), "yyyyMMdd", "yyyMMdd");
	}
	
	public static String convertTWDate(String AD, String beforeFormat, String afterFormat) {// 轉年月格式
		if (AD == null)
			return "";
		java.text.SimpleDateFormat df4 = new java.text.SimpleDateFormat(beforeFormat);
		java.text.SimpleDateFormat df2 = new java.text.SimpleDateFormat(afterFormat);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(df4.parse(AD));
			if (cal.get(Calendar.YEAR) > 1492)
				cal.add(Calendar.YEAR, -1911);
			else
				cal.add(Calendar.YEAR, +1911);
			return df2.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
