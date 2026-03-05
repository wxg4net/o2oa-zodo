package com.x.zodo.gateway.control.jaxrs;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.x.base.core.project.jaxrs.AbstractActionApplication;
import com.x.zodo.gateway.control.jaxrs.guard.GuardAction;
import com.x.zodo.gateway.control.jaxrs.file.FileAction;
import com.x.zodo.gateway.control.jaxrs.gateway.PassportAction;
import com.x.zodo.gateway.control.jaxrs.hr.HrAction;
import com.x.zodo.gateway.control.jaxrs.unit.UnitAction;

/**
 * Jaxrs服务注册类，在此类中注册的Action会向外提供服务
 * @author sword
 */
@ApplicationPath("jaxrs")
public class ActionApplication extends AbstractActionApplication {

	@Override
	public Set<Class<?>> getClasses() {

		//提供服务的Action类需要在这里注册，不然无法向外提供服务
		this.classes.add( PassportAction.class);
		this.classes.add( GuardAction.class);
		this.classes.add( UnitAction.class);
		this.classes.add( FileAction.class);
		this.classes.add( HrAction.class);

		return this.classes;
	}

}
