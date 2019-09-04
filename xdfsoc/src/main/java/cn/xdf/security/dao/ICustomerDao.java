package cn.xdf.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.xdf.security.bean.CustomerInfo;


public interface ICustomerDao  extends JpaRepository<CustomerInfo, Long> {
	
	public CustomerInfo findByCustomerCode(String customerCode);
	
	@Query(value = "select customerCode from customerinfo")
	public List<String> findAllCustomerCode();

}
