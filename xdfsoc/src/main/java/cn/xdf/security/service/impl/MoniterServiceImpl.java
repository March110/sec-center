package cn.xdf.security.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.xdf.security.bean.CarCost;
import cn.xdf.security.bean.CargoReceipt;
import cn.xdf.security.bean.CargoReceiptDetail;
import cn.xdf.security.bean.ContactsService;
import cn.xdf.security.bean.CustomerAmount;
import cn.xdf.security.bean.CustomerBillClear;
import cn.xdf.security.bean.DriverAmount;
import cn.xdf.security.bean.DriverInfo;
import cn.xdf.security.bean.GoodsBill;
import cn.xdf.security.bean.LineOverall;
import cn.xdf.security.dao.ICarCostDao;
import cn.xdf.security.dao.ICargoReceiptDao;
import cn.xdf.security.dao.ICargoReceiptDetailDao;
import cn.xdf.security.dao.IContactsServiceDao;
import cn.xdf.security.dao.ICustomerAmountDao;
import cn.xdf.security.dao.ICustomerBillClearDao;
import cn.xdf.security.dao.IDriverAmountDao;
import cn.xdf.security.dao.IDriverClearDao;
import cn.xdf.security.dao.IDriverInfoDao;
import cn.xdf.security.dao.IGoodsBillDao;
import cn.xdf.security.dao.ILineOverallDao;
import cn.xdf.security.service.IMoniterService;


@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "moniterService")
public class MoniterServiceImpl implements IMoniterService {

	@Autowired
	private IGoodsBillDao goodsBillDao;
	
	@Autowired
	private ICargoReceiptDetailDao cargoReceiptDetailDao;
	
	@Autowired
	private ICargoReceiptDao cargoReceiptDao;
	
	@Autowired
	private ICustomerAmountDao customerAmountDao;
	
	@Autowired
	private IDriverAmountDao driverAmountDao;
	
	@Autowired
	private IDriverClearDao driverClearDao;
	
	@Autowired
	private ICustomerBillClearDao customerBillClearDao;
	
	@Autowired
	private IContactsServiceDao contactsServiceDao;
	
	@Autowired
	private ILineOverallDao lineOverallDao;
	
	@Autowired
	private IDriverInfoDao driverInfoDao;
	
	@Autowired
	private ICarCostDao carCostDao;

	@Override
	public List<GoodsBill> selectAllUnArrive() {
		List<GoodsBill> goodsBills = goodsBillDao.findAll();
		List<GoodsBill> goodsBillsUnArrive = new ArrayList<>();
		
		for(GoodsBill goodsBill:goodsBills) {
			System.out.println("goodsBill: " + goodsBill);
			CargoReceiptDetail cargoReceiptDetail = cargoReceiptDetailDao.findByGoodsBillDetailId(goodsBill.getGoodsBillCode()); //4.5
			System.out.println("cargoReceiptDetail:" + cargoReceiptDetail);
			CargoReceipt cargoReceipt = cargoReceiptDao.findByGoodsRevertBillCode(cargoReceiptDetail.getGoodsRevertBillId());  //4.6
			System.out.println(cargoReceipt);
			if (cargoReceipt == null) {
				continue;
			}
			
			Date arriveTime = cargoReceipt.getArriveTime();  //到货时间
			Date startCarryTime = cargoReceipt.getStartCarryTime();
			
			if(arriveTime != null && startCarryTime != null) {
				long difference = arriveTime.getTime() - startCarryTime.getTime();
				int day = (int) difference/(3600*24*1000);  //实际中转天数
				int cishu = (int) (goodsBill.getTransferFee()/1.3) ;//中转次数
				if(day > (cishu+1) ) {
					goodsBillsUnArrive.add(goodsBill);
				}	
			}
			
			
			
		}
		return goodsBillsUnArrive;
	}

	@Override
	public List<GoodsBill> selectAllUnTake() {
		List<GoodsBill> goodsBills = goodsBillDao.findAll();
		List<GoodsBill> goodsBillsUnTake = new ArrayList<>();
		
		for(GoodsBill goodsBill:goodsBills) {
			CargoReceiptDetail cargoReceiptDetail = cargoReceiptDetailDao.findByGoodsBillDetailId(goodsBill.getGoodsBillCode()); //4.5
			CargoReceipt cargoReceipt = cargoReceiptDao.findByGoodsRevertBillCode(cargoReceiptDetail.getGoodsRevertBillId());  //4.6
			if (cargoReceipt == null) {
				continue;
			}
			
			Date arriveTime = cargoReceipt.getArriveTime();  //到货时间
			Date factDealDate = goodsBill.getFactDealDate();  //预计交货时间
			if(arriveTime != null && factDealDate != null) {
				long difference = arriveTime.getTime() - factDealDate.getTime();
				int day = (int) difference/(3600*24*1000);  
				if(day>=3) {
					goodsBillsUnTake.add(goodsBill);
				}
			}
		}
		
		return goodsBillsUnTake;
	}

	@Override
	public List<CustomerAmount> selectAllCusAcount() {
		List<Object[]> strings = goodsBillDao.find();
		List<CustomerAmount> customerAmounts = new ArrayList<>();
		
		for(Object[] string : strings) {
			
			CustomerAmount customerAmount = new CustomerAmount();
			customerAmount.setSendGoodsCustomer( (String)string[0] );
			customerAmount.setCarriageTotal( (double)string[1] );
			customerAmount.setInsuranceTotal( (double)string[2] );
			customerAmount.setPieceAmountTotal( Integer.parseInt(String.valueOf(string[3])));

			customerAmountDao.save(customerAmount);
			customerAmounts.add(customerAmount);
		}		
		return customerAmounts;
	}

	@Override
	public List<DriverAmount> selectAllDriAcount() {
		
		List<Object[]> strings = driverClearDao.find();
		List<DriverAmount> driverAmounts = new ArrayList<>();
		
		for(Object[] string : strings) {
			
			DriverAmount driverAmount = new DriverAmount();
			driverAmount.setDriverCode( (String)string[0] );
			driverAmount.setCarryFeeTotal( (double)string[1] );
			driverAmount.setAddCarriageTotal( (double)string[2] );
			driverAmount.setTotal( Integer.parseInt(String.valueOf(string[3])) );

			driverAmountDao.save(driverAmount);
			driverAmounts.add(driverAmount);
		}		
		return driverAmounts;
		
	
	}

	@Override
	public List<ContactsService> printAllContactsService() {
		List<GoodsBill> goodsBills = goodsBillDao.findAll();
		List<ContactsService> contactsServices = new ArrayList<>();
		
		for(GoodsBill goodsBill:goodsBills) {
			
			String goodsBillCode = goodsBill.getGoodsBillCode();
			System.out.println("1查询到"+goodsBillCode);
			ContactsService contactsService = new ContactsService();
			contactsService.setSendGoodsCustomer(goodsBill.getSendGoodsCustomer());
			contactsService.setGoodsBillCode(goodsBillCode);
			contactsService.setSendGoodsAddr(goodsBill.getSendGoodsAddr());
			contactsService.setReceiveGoodsAddr(goodsBill.getReceiveGoodsAddr());
			contactsService.setCarriage(goodsBill.getCarriage());
			contactsService.setInsurance(goodsBill.getInsurance());
			contactsService.setSendGoodsDate(goodsBill.getSendGoodsDate());
			CustomerBillClear customerBillClear = customerBillClearDao.findByGoodsBillCode(goodsBillCode);
			if(customerBillClear != null) {
				contactsService.setBillMoney(customerBillClear.getBillMoney());
				contactsService.setMoneyReceivable(customerBillClear.getMoneyReceivable());
				contactsService.setReceivedMoney(customerBillClear.getReceivedMoney());
				
				contactsServiceDao.save(contactsService);
				System.out.println("2查询到"+contactsService.getGoodsBillCode());
				contactsServices.add(contactsService);
			}
			
		}
		return contactsServices;
	}

	@Override
	public List<LineOverall> printAllLineOverall() {
		
		lineOverallDao.truncateTable();
		
		List<Object[]> strings = cargoReceiptDao.find();
		List<LineOverall> lineOveralls = new ArrayList<>();
		
		for(Object[] string : strings) {
			
			LineOverall lineOverall = new LineOverall();
			lineOverall.setLoadStation( (String)string[0] );
			lineOverall.setDealGoodsStation( (String)string[1] );
			lineOverall.setAllCarriageTotal( (double)string[2] );
			lineOverall.setInsuranceTotal( (double)string[3] );
			lineOverall.setTimes(Integer.parseInt(String.valueOf(string[4])));

			lineOverallDao.save(lineOverall);
			lineOveralls.add(lineOverall);
		}			
		return lineOveralls;
	}

	@Override
	public List<CarCost> printAllCarCost() {
		 List<CarCost> carCosts = new ArrayList<>();
		List<DriverAmount> driverAmounts =  selectAllDriAcount();
		
		for(DriverAmount driverAmount : driverAmounts) {
			String driverCode = driverAmount.getDriverCode();
			
			
			
			if(carCostDao.findByDriverCode(driverCode) == null) {
				CarCost carCost = new CarCost();
				carCost.setDriverCode(driverCode);
				
				DriverInfo driverInfo = driverInfoDao.findById(driverCode);
				if(driverInfo!=null) {
					carCost.setCarNo(driverInfo.getCarNo());
					carCost.setCarType(driverInfo.getCarType());
					carCost.setAllowCarryWeight(driverInfo.getAllowCarryWeight());
					carCost.setCarWidth(driverInfo.getCarWidth());
					carCost.setGoodsHeight(driverInfo.getGoodsHeight());
					carCost.setCarryFeeTotal(driverAmount.getCarryFeeTotal());
					carCost.setAddCarriageTotal(driverAmount.getAddCarriageTotal());
					
					carCostDao.save(carCost);
					carCosts.add(carCost);
				}
				
			}
			else {
				carCosts.add(carCostDao.findByDriverCode(driverCode));
			}
			
			
			
		}
		return carCosts;
	}

	@Override
	public CarCost selectByCode(String driverCode) {
		// TODO Auto-generated method stub
		System.out.println(driverCode);
		return carCostDao.findByDriverCode(driverCode);
	}

	@Override
	public ContactsService selectByGoodsBillCode(String goodsBillCode) {
		// TODO Auto-generated method stub
		return contactsServiceDao.findByGoodsBillCode(goodsBillCode);
	}

	

}
