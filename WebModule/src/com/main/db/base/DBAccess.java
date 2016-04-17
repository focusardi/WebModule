package com.main.db.base;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DBAccess {
	
	@Autowired
	SqlSessionFactory sqlSessionFactoryCustom;
	
	public List<HashMap<String, Object>> selectList(String nameSpace, HashMap<String, Object> parameterMap) {
		
		SqlSession session = sqlSessionFactoryCustom.openSession();
		//return session.selectList(nameSpace, parameterMap, new RowBounds(1,15));
		List<HashMap<String, Object>> returnData = session.selectList(nameSpace, parameterMap);
		session.close();
		return returnData;
	}
	
	public List<HashMap<String, Object>> selectPageList(String nameSpace, HashMap<String, Object> parameterMap, int pageNum, int pageSize) {
		SqlSession session = sqlSessionFactoryCustom.openSession();
		List<HashMap<String, Object>> returnData = session.selectList(nameSpace, parameterMap, new RowBounds(pageNum, pageSize));
		session.close();
		return returnData;
	}
}
