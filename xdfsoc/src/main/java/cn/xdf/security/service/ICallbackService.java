package cn.xdf.security.service;

import cn.xdf.security.bean.CallbackInfo;

public interface ICallbackService {
	
	public boolean addInfo(CallbackInfo callbackInfo);
	
	public CallbackInfo findDetail(String goodsBillId, String type);

}
