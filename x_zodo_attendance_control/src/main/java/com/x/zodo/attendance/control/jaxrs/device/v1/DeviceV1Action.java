package com.x.zodo.attendance.control.jaxrs.device.v1;


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

@Path("attendance/device/v1")
@JaxrsDescribe("考勤设备V1更新系统时间接口")
public class DeviceV1Action extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger(DeviceV1Action.class);

    @JaxrsMethodDescribe(value = "更新系统时间", action = ActionDeviceTime.class)
    @GET
    @Path("{ip}/time/{time}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDeviceTime(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                 @JaxrsParameterDescribe("设备IP") @PathParam("ip") String ip,
                                 @JaxrsParameterDescribe("设备时间") @PathParam("time") String time) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);

        try {
            result = new ActionDeviceTime().execute(request, effectivePerson, ip, time);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "设置通讯密钥", action = ActionDeviceTime.class)
    @GET
    @Path("{ip}/communication/{password}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void setDeviceCommunicationPassword(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                 @JaxrsParameterDescribe("设备IP") @PathParam("ip") String ip,
                                 @JaxrsParameterDescribe("通讯密码") @PathParam("password") String password) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);

        String netmask = "255255255000";
        String gateway = "192168003001";

        try {
            result = new ActionHwDeviceCommunication().execute(request, effectivePerson, ip, netmask,  gateway, password);

        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }
}