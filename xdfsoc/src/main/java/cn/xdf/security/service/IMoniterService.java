package cn.xdf.security.service;

import java.util.List;

import cn.xdf.security.bean.CarCost;
import cn.xdf.security.bean.ContactsService;
import cn.xdf.security.bean.CustomerAmount;
import cn.xdf.security.bean.DriverAmount;
import cn.xdf.security.bean.GoodsBill;
import cn.xdf.security.bean.LineOverall;

public interface IMoniterService {

	List<GoodsBill> selectAllUnArrive();

	List<GoodsBill> selectAllUnTake();

	List<CustomerAmount> selectAllCusAcount();

	List<DriverAmount> selectAllDriAcount();

	List<ContactsService> printAllContactsService();

	List<LineOverall> printAllLineOverall();

	List<CarCost> printAllCarCost();

	CarCost selectByCode(String driverCode);

	ContactsService selectByGoodsBillCode(String goodsBillCode);


}
