package cn.xdf.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.xdf.security.bean.WorkOrder;
public interface IWorkOrderDao extends JpaRepository<WorkOrder,Long> {

//	@Query(value="select * from vultype where id=?1",nativeQuery = true)
//	public VulType findById(String vulId);
//	
//	@Query(value="select * from vultype",nativeQuery=true)
//	public List<VulType> findALLVulTypes();
//	
//	@Transactional
//	@Modifying
//	@Query(value = "update vultype set vul_name =?1,vul_desc=?2,vul_res=?3 where id =?4", nativeQuery = true)
//	public void updateVulType(String vulName, String vulDes,String vulRes,int id);
	
	
	@Transactional
	@Query(value="update ")
	public void saveWorkOrder(String department,String bizLine,String proName,String proManager,String applyer ,String priority,String appName,String appDesc,String framework,String db,String middleware,String remarks);
	
}
