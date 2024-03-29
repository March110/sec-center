package cn.xdf.security.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.CustomerReceiptInfo;

public interface ICustomerReceiptInfoDao extends JpaRepository<CustomerReceiptInfo, Long>{
	
	public Page<CustomerReceiptInfo> findByReceiveGoodsPerson(String receiveGoodsPerson, Pageable pageable);

}
