package cn.xdf.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xdf.security.bean.VulType;
import cn.xdf.security.service.IVulTypeService;
import cn.xdf.security.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@Api(value="漏洞类型Controller")
@ControllerAdvice
@RestController
public class VulTypeController extends ReturnType{
	@Autowired
	private IVulTypeService vulTypeService;
	
	@ApiOperation(value="添加漏洞词条",notes="添加一个新漏洞词条")
	@RequestMapping(value="/addVultype",method=RequestMethod.POST,produces="application/json")
	public String addVulType(VulType vultype) {
		boolean flag = false;
		flag = vulTypeService.save(vultype);
		if(!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value="/deleteVultype/{id}",method=RequestMethod.DELETE,produces="application/json")
	public String deleteVulType(@PathVariable("id") String id) {
		boolean flag = false;
		flag = vulTypeService.delete(id);
		if(!flag) {
			return ERROR;
		}else {
			return SUCCESS;
		}
	}
	
	@ApiOperation(value="漏洞词条更新",notes="根据id更新漏洞词条信息")
	@RequestMapping(value="/updateVultype", method=RequestMethod.PUT)
	public String updateVulType(VulType vultype) {
		System.out.println("modify in conroller: name= "+vultype.getVulName());
		boolean flag = false;
		flag = vulTypeService.update(vultype);
		if(!flag) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequestMapping(value="/selectAllVultypesByPage",method=RequestMethod.GET)
	public Result selectAllVultypesByPage(@RequestParam("pageNum") int pageNum,@RequestParam("limit") int limit) {
	//	System.out.println(pageNum+", "+limit);
		Pageable pageable = PageRequest.of(pageNum-1,limit);
		Page<VulType> page = vulTypeService.selectAllVultypeByPage(pageable);
		System.out.println(page.getTotalElements()+" page "+page.getContent());
		Result result = new Result(200,"SUCCESS",(int)page.getTotalElements(),page.getContent());
	
		return result;
	}
	
	@RequestMapping(value="/selectVultypeById/{id}",method=RequestMethod.GET)
	public VulType selectById(@PathVariable("id") String id){
	//	System.out.println("id= "+id);
		VulType vulT = vulTypeService.selectVulTypeById(id);
 		return vulT;
	}
	
	/*
	@RequestMapping(value="/selecAll",method=RequestMethod.GET)
	public Result SelectAll() {
		List<VulType> vulTypes = vulTypeService.findAll();
		Result result = new Result(200,"SUCCESS",vulTypes.size(),vulTypes);
		return result;
	}
	
	*/
	
	
	
	
}
