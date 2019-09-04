package cn.xdf.security.service;

import java.util.List;

import cn.xdf.security.bean.RouteInfo;

public interface IRouteService {
	
	public void generateRoute();
	
	public List<RouteInfo> findAllRouteInfos();

}
