package cn.xdf.security.service.impl;


import org.springframework.transaction.annotation.Transactional;

import cn.xdf.security.bean.VulType;
import cn.xdf.security.dao.IVulTypeDao;
import cn.xdf.security.service.IVulTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;


@Transactional(propagation=Propagation.REQUIRED)
@Service(value="vulTypeService")
public class VulTypeServiceImpl implements IVulTypeService{
	@Autowired
	private IVulTypeDao vulTypeDao;
	
	@Override
	public VulType selectVulTypeById(String id) {
		
		return vulTypeDao.findById(id);
	}

//	@Override
//	public List<VulType> findAll() {
//		
//		return vulTypeDao.findALLVulTypes();
//	}

	@Override
	public boolean save(VulType vultype) {
		System.out.println("-----\r\n"+vultype);
		try {
			vulTypeDao.save(vultype);
			return true;
		}catch(Exception e) {
			System.err.println("vultype 插入信息失败！");
	 		return false;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			
			VulType vultype = vulTypeDao.findById(id);
			vulTypeDao.delete(vultype);
			return true;
		}catch(Exception e) {
			System.err.println("vultype 删除失败！");
			return false;
		}
 	}

	@Override
	public boolean update(VulType vultype) {
		
//		VulType temp = vulTypeDao.findById(Integer.parseInt(id));
//		vultype.setId(Integer.parseInt(id));
		
		try {
			
			vulTypeDao.updateVulType(vultype.getVulName(),vultype.getVulDesc(),vultype.getVulRes(),vultype.getId());
	 		return true;
		}catch(Exception e) {
			System.err.println("vultype 更新失败！");
	 		return false;
		}
	}

	@Override
	public Page<VulType> selectAllVultypeByPage(Pageable pageable) {
		
		return vulTypeDao.findAll(pageable);
	}


}
