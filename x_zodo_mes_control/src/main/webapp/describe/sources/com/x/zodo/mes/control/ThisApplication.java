package com.x.zodo.mes.control;

import com.x.base.core.project.Context;
import com.x.base.core.project.cache.CacheManager;
import com.x.zodo.mes.control.factory.MyBatisFlexFactory;


/**
 * 应用初始化及销毁业务处理
 * @author sword
 */
public class ThisApplication {

	protected static Context context;
//	public static final AttendanceRecordQueueTask attendanceRecordQueueTask = new AttendanceRecordQueueTask();

	public static Context context() {
		return context;
	}

	public static void init() throws Exception {
		try {
			CacheManager.init(context.clazz().getSimpleName());
			MyBatisFlexFactory.init();
//			context.startQueue(attendanceRecordQueueTask);
//			context.schedule(AttendanceTsCardSyncTask.class, "0 5 0 * * ?");
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
