package com.x.zodo.gateway.control.jaxrs.hr;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.connection.ActionResponse;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.jaxrs.WoValue;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.base.core.project.x_organization_assemble_express;
import com.x.base.core.project.x_processplatform_assemble_surface;
import com.x.zodo.gateway.control.ThisApplication;
import com.x.zodo.gateway.control.jaxrs.BaseAction;
import com.x.processplatform.core.express.assemble.surface.jaxrs.work.ActionCreateWi;
import com.x.zodo.gateway.control.jaxrs.gateway.ActionGenQRCode;
import com.x.zodo.gateway.control.queueTask.queue.KmsProcessRecordQueue;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 示例数据信息保存服务
 * @author sword
 */
public class ActionKmSalaryProcessConfirm extends BaseAction {
	private static  Logger logger = LoggerFactory.getLogger( ActionKmSalaryProcessConfirm.class );

	protected ActionResult<Wo> execute( HttpServletRequest request, EffectivePerson effectivePerson, JsonElement jsonElement ) throws Exception {
		ActionResult<Wo> result = new ActionResult<>();
		Wo wo = new Wo(0);
		Wi wi = this.convertToWrapIn(jsonElement, Wi.class);
		ActionResponse resp = ThisApplication.context().applications().
				getQuery(x_processplatform_assemble_surface.class,
						"data/work/" + wi.getWorkId());
		KmsWorkDataDto workDataDto = resp.getData(KmsWorkDataDto.class);
		JsonElement datatable = workDataDto.getDatatable();
		int count = 0;
		if (datatable.isJsonObject()) {
			JsonObject obj = datatable.getAsJsonObject();
			JsonArray list = obj.getAsJsonArray("data");
			if (list != null) {
				String kmsProcessId = "39757bb2-dab6-4dd2-baae-23e6d8db64b8";
				String targetProcessId = wi.getTargetProcessId();
				if (StringUtils.isEmpty(targetProcessId)) {
					targetProcessId = kmsProcessId;
				}
				for (JsonElement item : list) {
					Type type = new com.google.gson.reflect.TypeToken<Map<String, Object>>() {}.getType();
					Map<String, Object> kmsSalaryDto = gson.fromJson(item, type);
					ThisApplication.queueKmsProcessRecordTask.send(
							new KmsProcessRecordQueue(targetProcessId, workDataDto.getSalaryType(), workDataDto.getStartDate(), workDataDto.getEndDate(), kmsSalaryDto )
					);
					count++;
				}
				wo.setValue(count);
				result.setData(wo);
			}

		}
		return result;
	}

	/**
	 * 用于接受前端传入的对象型参数的帮助类
	 *
	 */
	public static class Wi extends QueryKmsWorkDto {

		public static final WrapCopier<Wi, QueryKmsWorkDto> copier = WrapCopierFactory.wi( Wi.class, QueryKmsWorkDto.class,  null, JpaObject.FieldsUnmodify );

	}

	/**
	 * 用于输出响应内容的帮助类
	 *
	 */
	public static class Wo extends WoValue {
		public Wo( Integer count ) {
			setValue( count );
		}
	}
}
