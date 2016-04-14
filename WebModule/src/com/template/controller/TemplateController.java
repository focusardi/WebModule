package com.template.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.main.db.dao.WmSysConfigMapper;
import com.main.db.model.WmSysConfig;
import com.main.db.model.WmSysConfigExample;
import com.main.db.model.WmSysConfigKey;

@Controller
public class TemplateController {
	
	@Autowired
	WmSysConfigMapper wmSysConfigMapper;
	
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		System.out.println("123333");
		WmSysConfigKey k = new WmSysConfigKey();
		k.setConfigName("AP_NAME");
		WmSysConfig a = wmSysConfigMapper.selectByPrimaryKey(k);
		
		WmSysConfigExample b = new WmSysConfigExample();
		List<WmSysConfig> dataList = wmSysConfigMapper.selectByExample(b);
		
		System.out.println(dataList.size());
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Hello World, Spring MVC Tutorial</h3></div><br><br>";
		return new ModelAndView("template/welcome", "message", message);
		
		
		
	}
}
