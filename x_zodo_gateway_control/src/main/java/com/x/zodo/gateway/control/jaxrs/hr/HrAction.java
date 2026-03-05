package com.x.zodo.gateway.control.jaxrs.hr;

import com.google.gson.JsonElement;
import com.x.base.core.project.annotation.JaxrsDescribe;
import com.x.base.core.project.annotation.JaxrsMethodDescribe;
import com.x.base.core.project.annotation.JaxrsParameterDescribe;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.http.HttpMediaType;
import com.x.base.core.project.jaxrs.ResponseFactory;
import com.x.base.core.project.jaxrs.StandardJaxrsAction;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 * @author sword
 */
@Path("hr")
@JaxrsDescribe("人力资源管理")
public class HrAction extends StandardJaxrsAction {

	private static Logger logger = LoggerFactory.getLogger( HrAction.class );

	@JaxrsMethodDescribe( value = "通过工作流ID获取业务数据创建审批流程", action = ActionKmSalaryProcessConfirm.class )
	@POST
	@Path("km/salary/process/confirm")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createKmSalaryProcessConfirm(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
						@JaxrsParameterDescribe("工作流参数") JsonElement jsonElement) {
		ActionResult<ActionKmSalaryProcessConfirm.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		try {
			result = new ActionKmSalaryProcessConfirm().execute( request, effectivePerson, jsonElement );
		} catch (Exception e) {
			logger.error(e, effectivePerson, request, null);
			result.error(e);
		}
		asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
	}

}
