package cn.xdf.security.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.xdf.security.bean.DriverInfo;

public interface IDriverInfoService {
	
	public Page<DriverInfo> findAllByPage(Pageable pageable);
	
	public boolean addNewDriver(DriverInfo driverInfo);
	
	public boolean updateById(String id, DriverInfo driverInfo);
	
	public DriverInfo findById(String id);
	
	public boolean deleteById(String id);
	
	public List<String> findAllId();

}
