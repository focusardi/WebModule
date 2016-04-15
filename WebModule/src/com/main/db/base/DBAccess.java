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
		return session.selectList(nameSpace, parameterMap);
	}
	
	public List<HashMap<String, Object>> selectPageList(String nameSpace, HashMap<String, Object> parameterMap, int beginIndex, int endIndex) {
		SqlSession session = sqlSessionFactoryCustom.openSession();
		return session.selectList(nameSpace, parameterMap, new RowBounds(beginIndex, endIndex));
	}
}
