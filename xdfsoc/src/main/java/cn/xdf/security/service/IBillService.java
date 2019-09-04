package cn.xdf.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.xdf.security.bean.BillInfo;
import cn.xdf.security.bean.BillRelease;
import cn.xdf.security.bean.GoodsReceiptInfo;

public interface IBillService {
	
	public Page<BillInfo> findAllByPage(Pageable pageable);
	
	public Page<BillInfo> findNotRelease(Pageable pageable);
	
	public boolean addRelease(BillRelease billRelease);
	
	public boolean addGoodsReceipt(GoodsReceiptInfo goodsReceiptInfo);

}
