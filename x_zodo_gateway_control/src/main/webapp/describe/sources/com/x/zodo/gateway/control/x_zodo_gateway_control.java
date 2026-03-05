package com.x.zodo.gateway.control;

import com.x.base.core.project.Deployable;
import com.x.base.core.project.annotation.Module;
import com.x.base.core.project.annotation.ModuleCategory;
import com.x.base.core.project.annotation.ModuleType;

/**
 * 正道OA系统网关
 * name 应用工程业务简要描述
 * packageName web应用工程类包路径
 * containerEntities 业务需要访问的实体类（需全路径，多个类逗号隔开）
 * storeJars 需要访问平台的实体类工程
 * customJars 需要访问的自定义工程
 * @author sword
 */
@Module(type = ModuleType.ASSEMBLE, category = ModuleCategory.CUSTOM, name = "正道综合网关", packageName = "com.x.zodo.gateway.control", containerEntities = {
		"com.x.zodo.gateway.entity.ZodoGatewayLog",
		"com.x.zodo.gateway.entity.ZodoPassportBlack",
		"com.x.organization.core.entity.Unit",
		"com.x.query.core.entity.Item",
		"com.x.processplatform.core.entity.content.WorkCompleted" }, storeJars = {
		"x_organization_core_entity",
		"x_processplatform_core_entity",
		"x_query_core_entity",
		"x_organization_core_express" }, customJars = { "x_zodo_gateway_entity" })
public class x_zodo_gateway_control extends Deployable {
}
