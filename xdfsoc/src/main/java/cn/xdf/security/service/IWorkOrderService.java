package cn.xdf.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.xdf.security.bean.WorkOrder;

public interface IWorkOrderService {


	public boolean save(WorkOrder workOrder);
	public boolean delete(String id);
	public boolean update(WorkOrder workOrder);
	
	public Page<WorkOrder> selectAllByPage(Pageable pageable);
	public WorkOrder selectOneById(long id);
	
	
}
