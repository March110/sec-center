package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.CustomerAmount;


public interface ICustomerAmountDao extends JpaRepository<CustomerAmount, Long>{

//	@Modifying
//	@Query(value = "select sendGoodsCustomer,sum(carriage) as carriageTotal ,sum(insurance) as insuranceTotal ,count(sendGoodsCustomer) as pieceAmountTotal from goodsbill group by sendGoodsCustomer order by pieceAmountTotal DESC")
//	List<CustomerAmount> find();

}
