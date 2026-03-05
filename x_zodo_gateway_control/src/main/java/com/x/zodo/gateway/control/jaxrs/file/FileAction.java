package com.x.zodo.gateway.control.jaxrs.file;

import com.google.gson.JsonElement;
import com.x.base.core.project.annotation.JaxrsDescribe;
import com.x.base.core.project.annotation.JaxrsMethodDescribe;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.http.HttpMediaType;
import com.x.base.core.project.jaxrs.ResponseFactory;
import com.x.base.core.project.jaxrs.StandardJaxrsAction;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.gateway.control.jaxrs.BaseAction;
import com.x.zodo.gateway.control.jaxrs.gateway.ActionGetPass;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 * @author sword
 */
@Path("file")
@JaxrsDescribe("正道应用文件接口")
public class FileAction extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger( FileAction.class );

	@JaxrsMethodDescribe( value = "上传文件档案", action = ActionGetPass.class )
	@POST
	@Path("upload")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public void uploadFile(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request) {
		ActionResult<JsonElement> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);

		try {
		} catch (Exception e) {
			logger.error(e, effectivePerson, request, null);
			result.error(e);
		}
		asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
	}

}
