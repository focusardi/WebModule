package com.template.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.main.base.BaseFacade;
import com.main.db.dao.WmSysConfigMapper;
import com.main.db.model.WmSysConfig;
import com.main.db.model.WmSysConfigExample;
import com.main.db.model.WmSysConfigKey;

@Service
@Scope("prototype")
public class TemplateFacade extends BaseFacade {
	
	@Autowired
	WmSysConfigMapper wmSysConfigMapper;
	
//	@Autowired
//	SqlSessionFactory sqlSessionFactoryCustom;
	
	public void doList() throws Exception {
		System.out.println("TemplateFacade");
		if (request == null) {
			System.out.println("request is null");
			
		} else {
			System.out.println(request);
			System.out.println(requestMap);			
			System.out.println(request.getParameter("pageNum"));
			System.out.println(getParameter("pageNum"));
			
			System.out.println(request.getAttribute("TEST"));
		}
		
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
		//map.put("CONFIG_NAME", "AP_NAME");
		
//		SqlSession session = sqlSessionFactoryCustom.openSession();
//		
//		List<?> reList = session.selectList("com.template.service.configList.getConfigList", map);
		
		List<?> reList = objDB.selectList("com.template.service.configList.getConfigList", map);
		
		System.out.println(reList.size());
		
		test();
	}
	
	public void test() {
		
	}
	
	public List<HashMap<String, Object>> getGridData() throws Exception {
		
		//AP_NAME10
		HashMap<String, Object> parameterMap= new HashMap<String, Object>();
		parameterMap.put("CONFIG_NAME", "AP_NAME10");
		parameterMap.put("CONFIG_VALUE", "<script>alert(\"123\");</script>");
		parameterMap.put("CONFIG_DESCRIPTION", null);
		objDB.update("com.template.service.configList.updateConfigTest", parameterMap);
		
		
		//batch test
		List<String> batchList = new ArrayList<String>();
		batchList.add("AP_NAME13");
		batchList.add("AP_NAME14");
		parameterMap.put("list", batchList);
		objDB.update("com.template.service.configList.updateConfigBatchTest", parameterMap);
		
		
		return objDB.selectPageList("com.template.service.configList.getConfigJoinCodeList", null, pageNum, pageSize);
		
	}
}
