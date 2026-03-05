package com.x.zodo.mes.control.jaxrs;

import com.x.base.core.project.jaxrs.AbstractActionApplication;
import com.x.zodo.mes.control.jaxrs.device.DeviceAction;

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

		this.classes.add( DeviceAction.class );

		return this.classes;
	}

}
