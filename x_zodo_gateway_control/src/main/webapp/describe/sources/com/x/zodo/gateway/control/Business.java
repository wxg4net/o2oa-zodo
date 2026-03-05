package com.x.zodo.gateway.control;

import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.project.cache.Cache;
import com.x.organization.core.entity.*;
import com.x.organization.core.express.Organization;

import com.x.zodo.gateway.control.factory.UnitFactory;
import com.x.zodo.gateway.control.factory.ZodoGatewayLogFactory;

/**
 * 应用业务服务类
 * @author sword
 */
public class Business {

	private EntityManagerContainer emc;

	public Business(EntityManagerContainer emc) throws Exception {
		this.cacheCategory = new Cache.CacheCategory(Group.class, Role.class, Person.class, PersonAttribute.class, Unit.class,
				UnitDuty.class, UnitAttribute.class, Identity.class);
		this.emc = emc;
	}

	public EntityManagerContainer entityManagerContainer() {
		return this.emc;
	}

	/**
	 * 组织架构管理相关的工厂服务类
	 */
	private Organization organization;

	private final Cache.CacheCategory cacheCategory;

	/**
	 * 示例数据表工厂服务类
	 */
	private ZodoGatewayLogFactory zodoGatewayLogFactory;

	public ZodoGatewayLogFactory sampleEntityClassNameFactory() throws Exception {
		if (null == this.zodoGatewayLogFactory) {
			this.zodoGatewayLogFactory = new ZodoGatewayLogFactory( this );
		}
		return zodoGatewayLogFactory;
	}

	public Cache.CacheCategory cache() {
		return cacheCategory;
	}

	private UnitFactory unit;

	public UnitFactory unit() throws Exception {
		if (null == this.unit) {
			this.unit = new UnitFactory(this);
		}
		return unit;
	}

	public Organization organization() throws Exception {
		if (null == this.organization) {
			this.organization = new Organization(ThisApplication.context());
		}
		return organization;
	}

}
