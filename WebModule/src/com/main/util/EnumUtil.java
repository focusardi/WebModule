package com.main.util;

public class EnumUtil {
	
	public enum TestType {		
		GRID_DATA,
		SEARCH_PARAMETER		
	}
	
	public enum ControllerReturnType {
		
		GRID_LIST_DATA(ConstantUtil.ControllerReturnType.GRID_LIST_DATA),
		SEARCH_PARAMETER(ConstantUtil.ControllerReturnType.SEARCH_PARAMETER);
		
		private String value;
		private ControllerReturnType(String value) {
			this.value = value;
		}
		
		public String getValue() {
	        return this.value;
	    }
	}
	
}
