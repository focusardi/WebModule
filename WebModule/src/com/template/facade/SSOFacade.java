package com.template.facade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.main.base.BaseFacade;
import com.main.db.dao.WmMainAuthcodeMapper;
import com.main.db.dao.WmMainAuthcookieMapper;
import com.main.db.model.WmMainAuthcode;
import com.main.db.model.WmMainAuthcookie;
import com.main.util.WebModuleUtil;

@Service
@Scope("prototype")
public class SSOFacade extends BaseFacade {
	
	@Autowired
	WmMainAuthcodeMapper wmMainAuthcodeMapper;
	
	@Autowired
	WmMainAuthcookieMapper wmMainAuthcookieMapper;
	
	
	public boolean validAccountPassword() throws Exception {
		
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("IDNO", getParameter("account"));
		dataMap.put("PASSWORD", getParameter("password"));
		dataMap.put("LAST_LOGIN_TIME", WebModuleUtil.getCurrentTWTime());
		
		int r = objDB.update("com.template.service.sso.validAccountPassword", dataMap);
		
		System.out.println(">>"+r);
		if (r > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public String getAuthCode() throws Exception {
		
		String uuid = UUID.randomUUID().toString();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		date.setTime(date.getTime() + 30000);
		
		WmMainAuthcode record = new WmMainAuthcode();
		record.setIdno(getParameter("account"));
		record.setCode(uuid);
		record.setSysId("ARDI");
		record.setExpiredTime(WebModuleUtil.convertTWDate(dateFormat.format(date), "yyyyMMddHHmmssSSS", "yyyMMddHHmmssSSS"));
		
		wmMainAuthcodeMapper.insert(record);
		
		return uuid;
	}
	
	public String getNewSSOCookie() throws Exception {
		
		WmMainAuthcookie record = new WmMainAuthcookie();		
		
		String uuid = UUID.randomUUID().toString();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		date.setTime(date.getTime() + 300000000);
		
		record.setIdno(getParameter("account"));
		record.setCookieId(uuid);
		record.setExpiredTime(WebModuleUtil.convertTWDate(dateFormat.format(date), "yyyyMMddHHmmssSSS", "yyyMMddHHmmssSSS"));
		
		wmMainAuthcookieMapper.insert(record);
		
		return uuid;
	}
	
	
}
