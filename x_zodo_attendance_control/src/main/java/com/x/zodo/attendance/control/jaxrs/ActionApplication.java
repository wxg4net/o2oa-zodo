package com.x.zodo.attendance.control.jaxrs;

import com.x.base.core.project.jaxrs.AbstractActionApplication;
import com.x.zodo.attendance.control.jaxrs.device.v1.DeviceV1Action;
import com.x.zodo.attendance.control.jaxrs.device.v2.DeviceV2Action;
import com.x.zodo.attendance.control.jaxrs.record.RecordV2Action;
import com.x.zodo.attendance.control.jaxrs.user.UserV2Action;

import javax.ws.rs.ApplicationPath;
import java.util.Set;

/**
 * Jaxrs服务注册类，在此类中注册的Action会向外提供服务
 * @author sword
 */
@ApplicationPath("jaxrs")
public class ActionApplication extends AbstractActionApplication {

	@Override
	public Set<Class<?>> getClasses() {

		this.classes.add( DeviceV1Action.class );
		this.classes.add( DeviceV2Action.class );
		this.classes.add( RecordV2Action.class );
		this.classes.add( UserV2Action.class );

		return this.classes;
	}

}
