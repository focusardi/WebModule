package com.main.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.main.base.DBAccess;
import com.main.base.DBAccessImpl;
import com.main.db.dao.WmMainAuthcookieMapper;
import com.main.db.dao.WmSysSysidMapper;
import com.main.db.model.WmSysSysid;

public class SettingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	static List<WmSysSysid> staticSysList = new ArrayList<WmSysSysid>();
	
	ServletContext sc = null;
	
	@Autowired
	WmSysSysidMapper wmSysSysidMapper;
	
	public void init() throws ServletException {	
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
		sc = getServletContext();
		
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		try {
			doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
		doPost(request,response);
    }
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		staticSysList = wmSysSysidMapper.selectByExample(null);
		
		System.out.println("SettingServlet");
		
    }
	
	public static WmSysSysid getSysSetting(String SYS_ID) {
		
		for (int i = 0;i < staticSysList.size();i++) {
			if (SYS_ID.equals(staticSysList.get(i).getSysId())) {
				return staticSysList.get(i);
			}
		}
		
		return null;
	}
	
}
