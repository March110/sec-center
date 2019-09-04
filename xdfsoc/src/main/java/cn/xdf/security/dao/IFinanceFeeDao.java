package cn.xdf.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.FinanceFee;

public interface IFinanceFeeDao extends JpaRepository<FinanceFee, Long>{

	public List<FinanceFee> findByPayoutMonth(String PayoutMonth);
}
