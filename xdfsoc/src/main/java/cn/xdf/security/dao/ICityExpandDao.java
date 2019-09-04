package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.CityExpand;

public interface ICityExpandDao extends JpaRepository<CityExpand, Long> {
	
	public CityExpand findByCityId(int cityId);
	
	public CityExpand findById(int id);

}
