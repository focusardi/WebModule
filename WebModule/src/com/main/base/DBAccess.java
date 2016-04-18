package com.main.base;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class DBAccess {
	
	@Autowired
	SqlSessionFactory sqlSessionFactoryCustom;
	
	public List<HashMap<String, Object>> selectList(String nameSpace, HashMap<String, Object> parameterMap) throws Exception {
		
		SqlSession session = sqlSessionFactoryCustom.openSession();
		
		//return session.selectList(nameSpace, parameterMap, new RowBounds(1,15));
		List<HashMap<String, Object>> returnData = session.selectList(nameSpace, parameterMap);
		session.close();
		return returnData;
	}
	
	public List<HashMap<String, Object>> selectPageList(String nameSpace, HashMap<String, Object> parameterMap, int pageNum, int pageSize) throws Exception {
		SqlSession session = sqlSessionFactoryCustom.openSession();
		List<HashMap<String, Object>> returnData = null;
		
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<HashMap<String, Object>> data = session.selectList(nameSpace, parameterMap);
			
			returnData = data;
			
			//returnData = session.selectList(nameSpace, parameterMap, new RowBounds(pageNum, pageSize));

		} finally {
			session.close();
		}
		
		return returnData;
	}
}
