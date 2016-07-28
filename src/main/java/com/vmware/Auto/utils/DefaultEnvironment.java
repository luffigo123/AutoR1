package com.vmware.Auto.utils;

public class DefaultEnvironment {
	private static Config cfg = Config.getInstance();
	
	public static final String VSMIP = cfg.ConfigMap.get("VSMIPAddress");
	public static final String VSMUserName = cfg.ConfigMap.get("VSMUserName");
	public static final String VSMPassword = cfg.ConfigMap.get("VSMPassword");
	
	public static final String hostUserName = cfg.ConfigMap.get("hostUserName");
	public static final String hostPassword = cfg.ConfigMap.get("hostPassword");
	public static final String host001_IPAddress = cfg.ConfigMap.get("host002_IPAddress");
	public static final String host002_IPAddress = cfg.ConfigMap.get("host002_IPAddress");
	
	public static final String edgeNodeIP = cfg.ConfigMap.get("edgeNodeIP");
	public static final String edgeUserName = cfg.ConfigMap.get("edgeUserName");
	public static final String edgePasswd = cfg.ConfigMap.get("edgePasswd");
	public static final String edgeNode2_IP = cfg.ConfigMap.get("edgeNode2_IP");
	
	
	//Add new items for log module
	public static final String BU = cfg.ConfigMap.get("BU");
	public static final String Product = cfg.ConfigMap.get("Product");
	public static final String BuildId = cfg.ConfigMap.get("BuildId");
	public static final String BuildType = cfg.ConfigMap.get("BuildType");
	public static final String Branch = cfg.ConfigMap.get("Branch");
	public static final String TestType = cfg.ConfigMap.get("TestType");
	public static final String Locale = cfg.ConfigMap.get("Locale");	
	public static final String HostOS = cfg.ConfigMap.get("HostOS");
	public static final String HostOSPlatform = cfg.ConfigMap.get("HostOSPlatform");
	public static final String ServerBuildID = cfg.ConfigMap.get("ServerBuildID");
	public static final String BrowserType = cfg.ConfigMap.get("BrowserType");
	public static final String BrowserPlatform = cfg.ConfigMap.get("BrowserPlatform");
	public static final String BrowserVerNo = cfg.ConfigMap.get("BrowserVerNo");	
	public static final String TestSetName = cfg.ConfigMap.get("TestSetName");
	public static final String Description = cfg.ConfigMap.get("Description");
	public static final String Remark = cfg.ConfigMap.get("Remark");
	public static final String LogOnRacetrack = cfg.ConfigMap.get("LogOnRacetrack");
	public static final String User = cfg.ConfigMap.get("User");
	
	public static final String Release = cfg.ConfigMap.get("Release");
	
	
}
