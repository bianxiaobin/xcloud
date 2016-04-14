package com.xc.bl.map.service;

import java.util.List;

import com.xc.bl.pojo.Map;



public interface IMapInfo {
	public List<Map> getAllMaps();
	
	public Map getMapById(int id);
	
	public List<Map> getMapByProvinceId(int pid);
	
	public void addMap(Map map);
	
	public List<Map> getMapByName(String mname);
}
