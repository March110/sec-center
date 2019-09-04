package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.CarCost;

public interface ICarCostDao extends JpaRepository<CarCost, Long>{

	public CarCost findByDriverCode(String driverCode);


}
