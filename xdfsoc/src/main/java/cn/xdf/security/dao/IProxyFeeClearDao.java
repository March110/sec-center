package cn.xdf.security.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.ProxyFeeClear;

public interface IProxyFeeClearDao extends JpaRepository<ProxyFeeClear, Long> {
	
	public ProxyFeeClear findByGoodsBillCode(String goodsBillCode);
	
	
	
}