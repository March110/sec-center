package cn.xdf.security.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.xdf.security.bean.CargoReceiptDetail;
import cn.xdf.security.bean.GoodsBill;
import cn.xdf.security.bean.GoodsBillEvent;

public interface IGoodsBillService {
	
	public Map<?, ?> save(GoodsBill goodsBill);
	
	public boolean saveGoods(String goodsBillDetailId, CargoReceiptDetail cargoReceiptDetail);
	
	public Page<GoodsBillEvent> selectAllGoogsBillByPage(Pageable pageable);
	
	public Page<GoodsBillEvent> selectGoodsBillByEvent(String eventName, Pageable pageable);
	
	public GoodsBill selectByGoodsBillCode(String goodsBillCode);
	
	public boolean update(GoodsBill goodsBill);
	
	public boolean delete(String goodsBillCode);
	
	public List<GoodsBill> findDriverIdIsNull();
	
	public List<GoodsBill> findWaitReceive(String customerCode);
	
	public Page<GoodsBill> findInformGet(String type, Pageable pageable);
	
	public Page<GoodsBill> findOldInform(String type, Pageable pageable);
	
	public Page<GoodsBill> findAllGot(Pageable pageable);
	
}