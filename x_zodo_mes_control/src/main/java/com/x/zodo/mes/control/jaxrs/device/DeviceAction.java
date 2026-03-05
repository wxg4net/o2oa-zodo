package com.x.zodo.mes.control.jaxrs.device;

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
import java.util.List;


@Path("device/pda")
@JaxrsDescribe("考勤设备V1更新系统时间接口")
public class DeviceAction extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger(DeviceAction.class);

    @JaxrsMethodDescribe(value = "获取 PDA 设备信息", action = ActionPda.class)
    @GET
    @Path("flag/{flag}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getPda(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                          @JaxrsParameterDescribe("扫码枪标志") @PathParam("flag") String flag) {
        ActionResult<List<ActionPda.Wo>> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionPda().execute(request, effectivePerson, flag);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

}
