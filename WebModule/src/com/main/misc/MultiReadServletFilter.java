package com.main.misc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MultiReadServletFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain chain) throws IOException, ServletException {
		
		MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);
		
		if (multiReadRequest.getMethod().equals("POST") && multiReadRequest.getContentType().startsWith("multipart/form-data")) {
			request.setAttribute("multiReadMap", getFormParameter(multiReadRequest));			
		}
		
		chain.doFilter(multiReadRequest, response);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> getFormParameter(MultiReadHttpServletRequest request) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");

		List<?> items;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			request.setAttribute("message", e.getMessage());
			e.printStackTrace();
			return null;
		}

		Iterator<?> iter = items.iterator();

		String name = null;
		String value = null;
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.isFormField()) {
				// 一般欄位
				name = item.getFieldName();
				try {
					value = item.getString("utf-8");
				} catch (UnsupportedEncodingException e) {
					request.setAttribute("message", e.getMessage());
					e.printStackTrace();
					return null;
				}

				if (dataMap.containsKey(name)) {
					Object _value = dataMap.get(name);
					if (_value instanceof String) {
						Vector<Object> newValue = new Vector<Object>();
						newValue.add(_value);
						newValue.add(value);
						dataMap.put(name, newValue);
					} else {
						((Vector<String>) _value).add(value);
					}
				} else {
					dataMap.put(name, value);
				}
			} else {
				// 上傳檔案
			}
		}
		
		return dataMap;
	}

}
