package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.TransferComInfo;

public interface ITransferComInfoDao extends JpaRepository<TransferComInfo, Long> {

	public TransferComInfo findByCity(String city);

}
