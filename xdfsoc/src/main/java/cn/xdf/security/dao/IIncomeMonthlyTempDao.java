package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.IncomeMonthlyTemp;

public interface IIncomeMonthlyTempDao extends JpaRepository<IncomeMonthlyTemp, Long>{
	
	public IncomeMonthlyTemp findByMonth(String month);
}
