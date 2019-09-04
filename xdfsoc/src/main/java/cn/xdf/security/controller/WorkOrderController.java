package cn.xdf.security.controller;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xdf.security.bean.WorkOrder;
import cn.xdf.security.service.IWorkOrderService;
import cn.xdf.security.util.Result;
import io.swagger.annotations.Api;

@CrossOrigin
@Api(value="安全测试工单Controller")
@ControllerAdvice
@RestController
public class WorkOrderController extends ReturnType{
	
	@Autowired
	private IWorkOrderService workOrderService;
	
	@RequestMapping(value="/createWorkOrder",method=RequestMethod.POST,produces="application/json")
	public String createWorkOrder(WorkOrder workOrder) {
		boolean flag = false;
		flag = workOrderService.save(workOrder);
		if(!flag) {
			return ERROR;
		}else {
			return SUCCESS;
		}
	}
	@RequestMapping(value="/selectWorkOrderByPage",method=RequestMethod.GET)
	public Result selectWorkOrderByPage(@RequestParam("pageNum") int pageNum,@RequestParam("limit") int limit) {
		Pageable pageable = PageRequest.of(pageNum-1,limit);
		Page<WorkOrder> page = workOrderService.selectAllByPage(pageable);
		Result result = new Result(200,"SUCCESS",(int)page.getTotalElements(),page.getContent());
		return result;
	} 
}
