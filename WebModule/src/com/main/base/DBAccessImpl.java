package com.main.base;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


public class DBAccessImpl implements DBAccess {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	public List<HashMap<String, Object>> selectList(String nameSpace, HashMap<String, Object> parameterMap) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<HashMap<String, Object>> returnData = null;
		
		try {
			returnData = session.selectList(nameSpace, parameterMap);
		} finally {
			session.close();
		}
		
		return returnData;
	}
	
	public List<HashMap<String, Object>> selectPageList(String nameSpace, HashMap<String, Object> parameterMap, int pageNum, int pageSize) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<HashMap<String, Object>> returnData = null;
		
		try {
			PageHelper.startPage(pageNum, pageSize);
			returnData = session.selectList(nameSpace, parameterMap);						
		} finally {
			session.close();			
		}
		
		return returnData;
	}
	
	public int insert(String nameSpace, HashMap<String, Object> parameterMap) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		int returnInt = 0;
		
		try {
			returnInt = session.insert(nameSpace, parameterMap);		
		} finally {
			session.close();
		}
		
		return returnInt;
	}
	
	public int update(String nameSpace, HashMap<String, Object> parameterMap) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		int returnInt = 0;
		
		try {
			returnInt = session.update(nameSpace, parameterMap);		
		} finally {
			session.close();
		}
		
		return returnInt;
	}
	
	public int delete(String nameSpace, HashMap<String, Object> parameterMap) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession();
		int returnInt = 0;
		
		try {
			returnInt = session.delete(nameSpace, parameterMap);		
		} finally {
			session.close();
		}
		
		return returnInt;
	}
	
}
