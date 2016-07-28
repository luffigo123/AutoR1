package com.vmware.Auto.service.GroupingObjects;

import java.util.ArrayList;

import com.vmware.Auto.model.GroupingObjects.IPSets;
import com.vmware.Auto.service.Service;
import com.vmware.Auto.utils.DefaultEnvironment;
import com.vmware.Auto.utils.JsonUtils;
import com.vmware.Auto.utils.SpringUtils;
import com.vmware.Auto.utils.TestData;
import com.vmware.Auto.utils.VerifyUtils;

public class IPSetsService {
	
	private String vmsIP = null;
	private Service service = null;
	private String url = null;
	
	//set default IPSets dsplay_name
	public String display_name = "IPSets" + TestData.NativeString;
	
	/**
	 * get default IPSets instance
	 * @return
	 */
	public IPSets getDefaultIPSets(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("192.168.1.1");
		IPSets ipsets = new IPSets(display_name,list);
		return ipsets;
	}
	
	public String getDefaultIPSetId(){
		IPSets ipset = this.getDefaultIPSets();
		String ipSetsName = ipset.getDisplay_name();
		if(!this.isExist(ipSetsName)){
			this.addIPSets(ipset);
		}
		
		String ipSetId = this.getIpSetsId(ipSetsName);
		return ipSetId;
	}
	
	
	public IPSetsService() {
		super();
		service = SpringUtils.getService();
		vmsIP = DefaultEnvironment.VSMIP;
		url = "https://" + vmsIP + "/api/v1/ip-sets/";
	}

	
	/**
	 * get specific ipSetsId
	 * @param ipSetsName
	 * @return
	 */
	public String getIpSetsId(String ipSetsName){
		JsonUtils jsonUtils = new JsonUtils();
		String queryInfo = service.queryObject(url);
		String promptPropertyName = "display_name";
		String promptPropertyValue = ipSetsName;
		String targetPropertyName = "id";
		String tzid = jsonUtils.getPropertyValue(queryInfo, promptPropertyName, promptPropertyValue, targetPropertyName);
		return tzid;
	}
	
	/**
	 * Add an IPSets
	 * @param ipSets
	 */
	public void addIPSets(IPSets ipSets){
		service.addObject(ipSets, url);
	}
	
	/**
	 * modify the specific IPSets
	 * @param ipSetsName
	 * @param newIPSets
	 */
	public void modifyIPSets(String orgIpSetsName, IPSets newIPSets){

		JsonUtils jsonUtils = new JsonUtils();
		String queryInfo = service.queryObject(url);
		String promptPropertyName = "display_name";
		String promptPropertyValue = orgIpSetsName;
		String targetPropertyName ="_revision";
		
		//Set the resource_type's value
		String resource_type = "IPSet";
		//Get the _revision's value
		String _revision_value = String.valueOf(jsonUtils.getPropertyValueIsInt(queryInfo, promptPropertyName, promptPropertyValue, targetPropertyName));
		
		//Create the IPSets which you wanted change to.
		IPSets finalIPSets = new IPSets(newIPSets.getDisplay_name(), newIPSets.getIp_addresses(),resource_type, _revision_value);
		
		
		//generate the edit url
		String tzid = this.getIpSetsId(orgIpSetsName);
		String modifyUrl = url + tzid;
		service.modifyObject(finalIPSets, modifyUrl);
	}
	
	/**
	 * delete specific IPSets
	 * @param ipSetsName
	 */
	public void deleteTIPSets(String ipSetsName){
		String tzid = this.getIpSetsId(ipSetsName);
		String deleteUrl = url + tzid;
		service.deleteObject(deleteUrl);
	}
	
	
	/**
	 * query the specific ipSets info
	 * @param ipSetsName
	 * @return
	 */
	public String queryIPSets(String ipSetsName){
		String tzid = this.getIpSetsId(ipSetsName);
		String queryUrl = url + tzid;
		return service.queryObject(queryUrl);
	}
	
	
	public boolean isExist(String ipSetsName){
		VerifyUtils verifyUtils = new VerifyUtils();
		String jsonString = service.queryObject(url);
		String targetPropertyName = "display_name";
		boolean b = verifyUtils.isTargetExist(jsonString, targetPropertyName, ipSetsName);
		return b;
	}
	

}
