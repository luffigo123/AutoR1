package com.vmware.Auto.model.GroupingObjects;

import java.io.Serializable;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class IPSets implements Serializable{
	private String display_name;
	private ArrayList<String> ip_addresses;
	private String resource_type;
	private String _revision;
	
	public IPSets() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param display_name
	 * @param ip_addresses		e.g. ["192.168.1.1-192.168.1.6","192.168.1.8","192.168.4.8/24"]
	 */
	public IPSets(String display_name, ArrayList<String> ip_addresses) {
		super();
		this.display_name = display_name;
		this.ip_addresses = ip_addresses;
	}

	/**
	 * 
	 * @param display_name		
	 * @param ip_addresses		e.g. ["192.168.1.1-192.168.1.6","192.168.1.8","192.168.4.8/24"]
	 * @param resource_type		IPSet
	 */
	public IPSets(String display_name, ArrayList<String> ip_addresses,
			String resource_type) {
		super();
		this.display_name = display_name;
		this.ip_addresses = ip_addresses;
		this.resource_type = resource_type;
	}
	
	
	/**
	 * 
	 * @param display_name
	 * @param ip_addresses		e.g. ["192.168.1.1-192.168.1.6","192.168.1.8","192.168.4.8/24"]
	 * @param resource_type		IPSet
	 * @param _revision
	 */
	public IPSets(String display_name, ArrayList<String> ip_addresses,
			String resource_type, String _revision) {
		super();
		this.display_name = display_name;
		this.ip_addresses = ip_addresses;
		this.resource_type = resource_type;
		this._revision = _revision;
	}

	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public ArrayList<String> getIp_addresses() {
		return ip_addresses;
	}
	public void setIp_addresses(ArrayList<String> ip_addresses) {
		this.ip_addresses = ip_addresses;
	}
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}

	public String get_revision() {
		return _revision;
	}

	public void set_revision(String _revision) {
		this._revision = _revision;
	}
	
	
}
