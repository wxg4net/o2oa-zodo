package com.x.zodo.gateway.control.factory;

import com.x.base.core.project.exception.ExceptionWhen;
import com.x.zodo.gateway.control.AbstractFactory;
import com.x.zodo.gateway.control.Business;
import com.x.zodo.gateway.entity.ZodoGatewayLog;

/**
 * 示例数据表基础功能服务类
 * @author sword
 */
public class ZodoGatewayLogFactory extends AbstractFactory {

	public ZodoGatewayLogFactory(Business business) throws Exception {
		super(business);
	}

	/**
	 * 获取指定Id的SampleEntityClassName信息对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ZodoGatewayLog get(String id ) throws Exception {
		return this.entityManagerContainer().find(id, ZodoGatewayLog.class, ExceptionWhen.none);
	}

}
