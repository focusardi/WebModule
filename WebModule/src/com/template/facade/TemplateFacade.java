package com.template.facade;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.main.db.base.DBAccess;
import com.main.db.dao.WmSysConfigMapper;
import com.main.db.model.WmSysConfig;
import com.main.db.model.WmSysConfigExample;
import com.main.db.model.WmSysConfigKey;

@Service
@Scope("prototype")
public class TemplateFacade {
	
	@Autowired
	WmSysConfigMapper wmSysConfigMapper;
	
	@Autowired
	DBAccess objDB;
	
//	@Autowired
//	SqlSessionFactory sqlSessionFactoryCustom;
	
	public void doList() throws Exception {
		System.out.println("TemplateFacade");
		
		WmSysConfigKey k = new WmSysConfigKey();
		k.setConfigName("AP_NAME");
		WmSysConfig a = wmSysConfigMapper.selectByPrimaryKey(k);
		
		WmSysConfigExample b = new WmSysConfigExample();
		List<WmSysConfig> dataList = wmSysConfigMapper.selectByExample(b);
		
		System.out.println(dataList.size());
		
		WmSysConfig inRecord = new WmSysConfig();
		inRecord.setConfigName("AP_NAME" + (dataList.size() + 1));
		inRecord.setConfigValue(dataList.get(0).getConfigValue());
		int r = wmSysConfigMapper.insert(inRecord);
		System.out.println("insert:" + r);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("CONFIG_NAME", "AP_NAME");
		
//		SqlSession session = sqlSessionFactoryCustom.openSession();
//		
//		List<?> reList = session.selectList("com.template.service.configList.getConfigList", map);
		
		List<?> reList = objDB.selectList("com.template.service.configList.getConfigList", map);
		
		System.out.println("123");
		
	}
}
