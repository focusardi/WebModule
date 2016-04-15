package com.main.util;

import java.math.BigDecimal;

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
}
