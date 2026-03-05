package com.x.zodo.gateway.control.jaxrs.guard;


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

@Path("guard")
@JaxrsDescribe("门禁设备设置接口")
public class GuardAction extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger(GuardAction.class);

    @JaxrsMethodDescribe(value = "设置设备系统时间", action = ActionHwDeviceGateV2.class)
    @GET
    @Path("{version}/device/{ip}/time/{time}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDeviceInfo(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                 @JaxrsParameterDescribe("设备版本") @PathParam("version") String version,
                                 @JaxrsParameterDescribe("设备IP") @PathParam("ip") String ip,
                                 @JaxrsParameterDescribe("设备时间") @PathParam("time") String time) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);

        try {
            switch (version) {
                case "v1":
                    result = new ActionHwDeviceTimeV1().execute(request, effectivePerson, ip, time);
                    break;
                case "v2":
                    result = new ActionHwDeviceTimeV2().execute(request, effectivePerson, ip, time);
                    break;
                default:
            }

        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }


    @JaxrsMethodDescribe(value = "设置门禁指令", action = ActionHwDeviceGateV2.class)
    @GET
    @Path("{version}/device/{ip}/action/{action}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDeviceDoorAction(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                 @JaxrsParameterDescribe("设备版本") @PathParam("version") String version,
                                 @JaxrsParameterDescribe("设备IP") @PathParam("ip") String ip,
                                 @JaxrsParameterDescribe("设备动作") @PathParam("action") String action) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);

        try {
            switch (version) {
                case "v1":
                    result = new ActionHwDeviceGateV1().execute(request, effectivePerson, ip, action);
                    break;
                case "v2":
                    result = new ActionHwDeviceGateV2().execute(request, effectivePerson, ip, action);
                    break;
                default:
            }
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }
}