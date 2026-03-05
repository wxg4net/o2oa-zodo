package com.x.zodo.mes.control;

import com.x.base.core.project.Deployable;
import com.x.base.core.project.annotation.Module;
import com.x.base.core.project.annotation.ModuleCategory;
import com.x.base.core.project.annotation.ModuleType;

/**
 * 门禁考勤设备管理
 * name 应用工程业务简要描述
 * packageName web应用工程类包路径
 * containerEntities 业务需要访问的实体类（需全路径，多个类逗号隔开）
 * storeJars 需要访问平台的实体类工程
 * customJars 需要访问的自定义工程
 * @author sword
 */
@Module(type = ModuleType.ASSEMBLE, category = ModuleCategory.CUSTOM, name = "正道MES服务", packageName = "com.x.zodo.mes.control", containerEntities = {
		"com.x.organization.core.entity.Group",
		"com.x.organization.core.entity.Role",
		"com.x.organization.core.entity.Person",
		"com.x.organization.core.entity.PersonAttribute",
		"com.x.organization.core.entity.Unit",
		"com.x.organization.core.entity.UnitDuty",
		"com.x.organization.core.entity.UnitAttribute",
		"com.x.organization.core.entity.Identity"
		 }, storeJars = {"x_attendance_core_entity", "x_organization_core_entity", "x_organization_core_express" }, customJars = { "x_zodo_mes_entity"  })
public class x_zodo_mes_control extends Deployable {
}
