package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.CustomerBillClear;

public interface ICustomerBillClearDao extends JpaRepository<CustomerBillClear, Long> {
	
	
	public CustomerBillClear findByGoodsBillCode(String billCode);



}