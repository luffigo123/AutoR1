package com.vmware.Auto.utils;

import java.util.ArrayList;

public class VerifyUtils {
	
	/**
	 * verify the specific property whether exist in Json String 
	 * @param jsonString
	 * @param targetPropertyName
	 * @param targetValue
	 * @return
	 */
	public boolean isTargetExist(String jsonString, String targetPropertyName, String targetValue){
		boolean flag = false ;
		if(jsonString.contains("results")){
			JsonUtils jsonUtils = new JsonUtils();
			ArrayList<String> list = jsonUtils.getSpecificPropertyValues(jsonString, targetPropertyName);
			for(int i =0; i< list.size(); i ++){
				if(targetValue.equalsIgnoreCase(list.get(i))){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

}
