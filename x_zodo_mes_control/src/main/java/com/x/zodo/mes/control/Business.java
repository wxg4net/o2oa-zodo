package com.x.zodo.mes.control;

import com.mybatisflex.core.MybatisFlexBootstrap;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.project.cache.Cache;
import com.x.base.core.project.organization.*;
import com.x.organization.core.express.Organization;
import com.x.organization.core.express.unit.UnitFactory;
import com.x.zodo.mes.control.factory.MyBatisFlexFactory;

/**
 * 应用业务服务类
 * @author sword
 */
public class Business {

	private final EntityManagerContainer emc;

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

	private Cache.CacheCategory cacheCategory;

	public Cache.CacheCategory cache() {
		return cacheCategory;
	}

	private UnitFactory unit;

	public Organization organization() throws Exception {
		if (null == this.organization) {
			this.organization = new Organization(ThisApplication.context());
		}
		return organization;
	}

	public static MybatisFlexBootstrap flexBootstrap() throws Exception {
        return MyBatisFlexFactory.getBootstrap();
	}

}
