package cn.xdf.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.TransferInfo;

public interface ITransferInfoDao extends JpaRepository<TransferInfo, Long> {

	public TransferInfo findByGoodsBillCodeAndTransferStation(String goodsBillCode, String transferStation);
	
	public List<TransferInfo> findByGoodsBillCode(String goodsBillCode);
	
}
