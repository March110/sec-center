package cn.xdf.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.xdf.security.bean.VulType;

public interface IVulTypeService {
	

	
	public boolean save(VulType vultype);
	public boolean delete(String id);
	public boolean update(VulType vultype);
	
	public Page<VulType> selectAllVultypeByPage(Pageable pageable);	
	public VulType selectVulTypeById(String id);
	
}
