package com.x.zodo.gateway.control.jaxrs.unit;


import com.x.base.core.project.annotation.JaxrsDescribe;
import com.x.base.core.project.annotation.JaxrsMethodDescribe;
import com.x.base.core.project.annotation.JaxrsParameterDescribe;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.http.HttpMediaType;
import com.x.base.core.project.jaxrs.ResponseFactory;

import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.gateway.control.jaxrs.BaseAction;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("unit")
@JaxrsDescribe("正道组织列表接口")
public class UnitAction extends BaseAction {

    private static final Logger logger = LoggerFactory.getLogger( UnitAction.class );

    @JaxrsMethodDescribe(value = "获取顶级组织", action = UnitAction.class)
    @GET
    @Path("top")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getList(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request) {
        ActionResult<List<ActionList.Wo>> result = new ActionResult<>();

        try {
            result = new ActionList().execute( request );
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "获取顶级或者指定组织的下级组织", action = UnitAction.class)
    @GET
    @Path("list/{name}/sub/direct")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getListSubDirect(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                        @JaxrsParameterDescribe("组织单元唯一名称") @PathParam("name")  String name) {
        ActionResult<List<ActionListSubDirect.Wo>> result = new ActionResult<>();

        try {
            result = new ActionListSubDirect().execute( request, name);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

}
