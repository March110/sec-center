package cn.xdf.security.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.xdf.security.bean.CustomerReceiptInfo;
import cn.xdf.security.bean.GoodsBill;
import cn.xdf.security.bean.TransferComInfo;
import cn.xdf.security.bean.TransferInfo;

public interface ITransferService {
	
	public boolean addCompany(TransferComInfo transferComInfo);
	
	public Page<TransferComInfo> findAllByPage(Pageable pageable);
	
	public List<GoodsBill> transferGoods(String type, String driverId);
	
	public List<GoodsBill> arriveGoods(String type, String driverId);
	
	public TransferComInfo findByGoodsBillCode(String goodsBillCode);
	
	public boolean addTransferInfo(TransferInfo transferInfo);
	
	public List<GoodsBill> findOnWayBills();
	
	public Page<TransferInfo> findInfoByPage(Pageable pageable);
	
	public boolean addCustomerReceiptInfo(CustomerReceiptInfo customerReceiptInfo);
	
	public Page<CustomerReceiptInfo> findCusRecPage(String customerCode, Pageable pageable);

}
