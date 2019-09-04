package cn.xdf.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.xdf.security.bean.CallbackInfo;

public interface ICallbackDao extends JpaRepository<CallbackInfo, Long> {
	
	public CallbackInfo findByGoodsBillIdAndType(String goodsBillId, String type);
	
}
