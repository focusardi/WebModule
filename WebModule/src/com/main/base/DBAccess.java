package com.main.base;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DBAccess {
	
	public List<HashMap<String, Object>> selectList(String nameSpace, HashMap<String, Object> parameterMap) throws Exception;

	public List<HashMap<String, Object>> selectPageList(String nameSpace, HashMap<String, Object> parameterMap, int pageNum, int pageSize) throws Exception;
	
	public int insert(String nameSpace, HashMap<String, Object> parameterMap) throws Exception;
	
	public int update(String nameSpace, HashMap<String, Object> parameterMap) throws Exception;
	
	public int delete(String nameSpace, HashMap<String, Object> parameterMap) throws Exception;
}
