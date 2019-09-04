package cn.xdf.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.ManageFee;

public interface IManageFeeDao extends JpaRepository<ManageFee, Long>{

	public List<ManageFee> findByPayoutMonth(String PayoutMonth);
	
	public ManageFee findById(int id);
}
