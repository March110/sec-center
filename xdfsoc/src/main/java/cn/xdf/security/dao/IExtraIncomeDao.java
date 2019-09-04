package cn.xdf.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.ExtraIncome;

public interface IExtraIncomeDao extends JpaRepository<ExtraIncome, Long>{

    public List<ExtraIncome> findByIncomeMonth(String incomeMonth);
	

}
