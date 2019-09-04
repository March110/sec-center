package cn.xdf.security.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.xdf.security.bean.BillInfo;
import cn.xdf.security.bean.BillRelease;
import cn.xdf.security.bean.GoodsReceiptInfo;
import cn.xdf.security.dao.IBillInfoDao;
import cn.xdf.security.dao.IBillReleaseDao;
import cn.xdf.security.dao.ICargoReceiptDao;
import cn.xdf.security.dao.ICargoReceiptDetailDao;
import cn.xdf.security.dao.IGoodsBillDao;
import cn.xdf.security.dao.IGoodsBillEventDao;
import cn.xdf.security.dao.IGoodsReceiptInfoDao;
import cn.xdf.security.service.IBillService;

@Service(value = "billService")
@Transactional(propagation = Propagation.REQUIRED)
public class BillServiceImpl implements IBillService {
	
	@Autowired
	private IBillInfoDao billInfoDao;
	
	@Autowired
	private IBillReleaseDao billReleaseDao;
	
	@Autowired
	private IGoodsBillEventDao goodsBillEventDao;
	
	@Autowired
	private IGoodsBillDao goodsBillDao;
	
	@Autowired
	private ICargoReceiptDao cargoReceiptDao;
	
	@Autowired
	private ICargoReceiptDetailDao cargoReceiptDetailDao;
	
	@Autowired
	private IGoodsReceiptInfoDao goodsReceiptInfoDao;

	@Override
	public Page<BillInfo> findAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return billInfoDao.findAll(pageable);
	}

	@Override
	public Page<BillInfo> findNotRelease(Pageable pageable) {
		// TODO Auto-generated method stub
		return billInfoDao.findNotRelease(pageable);
	}

	@Override
	public boolean addRelease(BillRelease billRelease) {
		// TODO Auto-generated method stub
		billRelease.setBillType("货运单");
		String billCode = billRelease.getBillCode();
		try {
			billReleaseDao.save(billRelease);
			goodsBillEventDao.updateEventName("未到", new Date(), billCode);
			String goodsRevertBillId = cargoReceiptDetailDao.findByGoodsBillDetailId(billCode).getGoodsRevertBillId();
			cargoReceiptDao.updateRelease(billRelease.getReceiveBillTime(), billRelease.getReceiveBillPerson(), "未到车辆", goodsRevertBillId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("单据明细表插入失败 | 货运单 & 货运回执信息 更新失败");
			return false;
		}
	}

	@Override
	public boolean addGoodsReceipt(GoodsReceiptInfo goodsReceiptInfo) {
		// TODO Auto-generated method stub
		String goodsRevertBillId = goodsReceiptInfo.getGoodsRevertCode();
		String billId = cargoReceiptDetailDao.findByGoodsRevertBillId(goodsRevertBillId).getGoodsBillDetailId();
		try {
			goodsReceiptInfoDao.save(goodsReceiptInfo);
			goodsBillEventDao.updateEventName("未结", new Date(), billId);
			goodsBillDao.updateFactDealDate(goodsReceiptInfo.getRceiveGoodsDate(), billId);
			cargoReceiptDao.updateArriveTime(goodsReceiptInfo.getRceiveGoodsDate(), "未结合同", goodsRevertBillId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("货物回执信息添加失败");
			return false;
		}
	}

}
