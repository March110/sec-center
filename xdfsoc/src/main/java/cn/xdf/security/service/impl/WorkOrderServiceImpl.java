package cn.xdf.security.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.xdf.security.bean.WorkOrder;
import cn.xdf.security.dao.IWorkOrderDao;
import cn.xdf.security.service.IWorkOrderService;

@Transactional(propagation=Propagation.REQUIRED)
@Service(value="workOrderService")
public class WorkOrderServiceImpl implements IWorkOrderService{
	protected static final Logger logger = LoggerFactory.getLogger(WorkOrderServiceImpl.class);

	@Autowired
	private IWorkOrderDao workOrderDao;
	@Override
	public boolean save(WorkOrder workOrder) {
		try {
			workOrderDao.save(workOrder);
			return true;
		}catch(Exception e) {
			logger.error("插入工单失败！");
	 		return false;
		}
 	}

	@Override
	public boolean delete(String id) {
 		return false;
	}

	@Override
	public boolean update(WorkOrder workOrder) {
 		return false;
	}

	@Override
	public Page<WorkOrder> selectAllByPage(Pageable pageable) {
 		return null;
	}

	@Override
	public WorkOrder selectOneById(long id) {
		Optional<WorkOrder> woOptional = workOrderDao.findById(id);
		if(woOptional.isPresent()) {
			WorkOrder workOrder = woOptional.get();
			return workOrder;
		}else {
			throw new EntityNotFoundException(String.valueOf(id));
 		}
	}

}
