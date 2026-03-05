package com.x.zodo.gateway.control.jaxrs.gateway;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
import com.x.zodo.gateway.entity.ZodoGatewayLog;

import java.util.List;


/**
 * @author sword
 */
@Path("pass")
@JaxrsDescribe("电子通行证网关接口")
public class PassportAction extends StandardJaxrsAction{

	private static Logger logger = LoggerFactory.getLogger( PassportAction.class );

	@JaxrsMethodDescribe( value = "获取出入电子流程证明", action = ActionGetPass.class )
	@GET
	@Path("job/{id}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getPass(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
						  @JaxrsParameterDescribe("出入证ID") @PathParam("id") String id) {
		ActionResult<JsonElement> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);

		try {
			ZodoGatewayLog zodoGatewayLog = new ZodoGatewayLog();
			zodoGatewayLog.setName("获取出入电子流程证明");
			zodoGatewayLog.setBody(id);
			zodoGatewayLog.setUserId(effectivePerson.getDistinguishedName());
			zodoGatewayLog.setUserName(effectivePerson.getName());
			zodoGatewayLog.setCategory("pass");
			new ActionSave().execute( request, effectivePerson, gson.toJsonTree(zodoGatewayLog));
			result = new ActionGetPass().execute( request, effectivePerson, id );
		} catch (Exception e) {
			logger.error(e, effectivePerson, request, null);
			result.error(e);
		}
		asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
	}

	@JaxrsMethodDescribe( value = "根据 Data 返回二维码内容", action = ActionGenQRCode.class )
	@GET
	@Path("qrcode/width/{width}/height/{height}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public void genQrCode(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
						  @JaxrsParameterDescribe("像素宽度") @PathParam("width") Integer width,
						  @JaxrsParameterDescribe("像素高度") @PathParam("height") Integer height) {
		ActionResult<ActionGenQRCode.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		try {
			result = new ActionGenQRCode().execute( request, effectivePerson, width, height, "");
		} catch (Exception e) {
			logger.error(e, effectivePerson, request, null);
			result.error(e);
		}
		asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
	}

	@JaxrsMethodDescribe( value = "根据 Data 返回二维码内容", action = ActionGenQRCode.class )
	@GET
	@Path("qrcode/width/{width}/height/{height}/data/{data}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public void genQrCodeFromData(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
						  @JaxrsParameterDescribe("像素宽度") @PathParam("width") Integer width,
						  @JaxrsParameterDescribe("像素高度") @PathParam("height") Integer height,
						  @JaxrsParameterDescribe("二维码内容") @PathParam("data") String data) {
		ActionResult<ActionGenQRCode.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		try {
			result = new ActionGenQRCode().execute( request, effectivePerson, width, height, data);
		} catch (Exception e) {
			logger.error(e, effectivePerson, request, null);
			result.error(e);
		}
		asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
	}


	@JaxrsMethodDescribe( value = "获取出入证扫描记录", action = ActionListPaging.class )
	@GET
	@Path("page/{page}/size/{size}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getPageList(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
			@JaxrsParameterDescribe("数据分页") @PathParam("page") Integer page,
			@JaxrsParameterDescribe("分页大小") @PathParam("size") Integer size) {
		ActionResult<List<ActionListPaging.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		try {
			result = new ActionListPaging().execute( effectivePerson, page, size );
		} catch (Exception e) {
			logger.error(e, effectivePerson, request, null);
			result.error(e);
		}
		asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
	}

	@JaxrsMethodDescribe( value = "创建日志", action = ActionSave.class )
	@POST
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
						 @JaxrsParameterDescribe("需要保存的信息") JsonElement jsonElement) {
		ActionResult<ActionSave.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);

		try {
			result = new ActionSave().execute( request, effectivePerson, jsonElement );
		} catch (Exception e) {
			logger.error(e, effectivePerson, request, null);
			result.error(e);
		}
		asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
	}

}
