package com.x.zodo.gateway.control;

import com.x.base.core.project.Context;
import com.x.base.core.project.cache.CacheManager;
import com.x.zodo.gateway.control.queueTask.KmsProcessRecordTask;
import com.x.zodo.gateway.control.schedule.GatewayTask;

/**
 * 应用初始化及销毁业务处理
 * @author sword
 */
public class ThisApplication {

	public static final KmsProcessRecordTask queueKmsProcessRecordTask = new KmsProcessRecordTask();

	protected static Context context;

	public static Context context() {
		return context;
	}

	public static void init() throws Exception {
		try {
			CacheManager.init(context.clazz().getSimpleName());
			context.startQueue(queueKmsProcessRecordTask);
			context.schedule(GatewayTask.class, "0 0 08 * * ?");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void destroy() {
		try {
			CacheManager.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
