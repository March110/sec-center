package com.ansel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ansel.bean.VulType;

public interface IVulTypeService {
	

	
	public boolean save(VulType vultype);
	public boolean delete(String id);
	public boolean update(String id,VulType vultype);
	
	public Page<VulType> selectAllVultypeByPage(Pageable pageable);	
	public VulType selectVulTypeById(String id);
	
	//public List<VulType> findAll();

	
//	   public boolean save(CustomerInfo customer);
//		
//		public boolean delete(String customerCode);
//		
//		public boolean update(String customerCode, CustomerInfo customer);
//		
//		public Page<CustomerInfo> selectAllCusByPage(Pageable pageable);
//		
//		public CustomerInfo selectByCustomerCode(String customerCode);
//		
//		public List<String> selectAllCusCode();
}
