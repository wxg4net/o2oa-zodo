package com.x.zodo.attendance.control.jaxrs.device.v2;


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
import com.x.zodo.attendance.control.jaxrs.device.v1.ActionDeviceTime;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("attendance/device/v2")
@JaxrsDescribe("考勤设备更新系统时间接口")
public class DeviceV2Action extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger(DeviceV2Action.class);

    @JaxrsMethodDescribe(value = "获取设备列表", action = ActionHwDevice.class)
    @GET
    @Path("list")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getList(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request) {
        ActionResult<List<ActionHwDevice.Wo>> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);

        try {
            result = new ActionHwDevice().execute(request, effectivePerson);

        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "获取启用设备列表", action = ActionHwDeviceOnline.class)
    @GET
    @Path("list/online")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getListOnline(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request) {
        ActionResult<List<ActionHwDeviceOnline.Wo>> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);

        try {
            result = new ActionHwDeviceOnline().execute(request, effectivePerson);

        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "设置系统时间", action = ActionDeviceTime.class)
    @GET
    @Path("{ip}/time/{time}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void setDeviceTime(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                 @JaxrsParameterDescribe("设备IP") @PathParam("ip") String ip,
                                 @JaxrsParameterDescribe("设备时间") @PathParam("time") String time) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);

        try {
            result = new ActionHwDeviceTimeUpdate().execute(request, effectivePerson, ip, time);

        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "设置设备通讯密钥", action = ActionHwDeviceCommunication.class)
    @GET
    @Path("communication/{ip}/password/{password}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void setDeviceCommunicationPassword(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                 @JaxrsParameterDescribe("设备IP") @PathParam("ip") String ip,
                                 @JaxrsParameterDescribe("通讯密码") @PathParam("password") String password) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionHwDeviceCommunication().execute(request, effectivePerson, ip, password);

        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }


    @JaxrsMethodDescribe(value = "设备远程开门", action = ActionHwDeviceOpenDoor.class)
    @GET
    @Path("openDoor/{host}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void openDoor(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                               @JaxrsParameterDescribe("设备IP") @PathParam("host") String host) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionHwDeviceOpenDoor().execute(request, effectivePerson, host);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "设备远程开门", action = ActionHwDeviceDoorControl.class)
    @GET
    @Path("door/{host}/status/{status}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void setDoorStatus(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                         @JaxrsParameterDescribe("设备IP") @PathParam("host") String host,
                              @JaxrsParameterDescribe("门禁状态") @PathParam("status") Integer status) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionHwDeviceDoorControl().execute(request, effectivePerson, host, status);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "获取设备参数", action = ActionHwDeviceSetting.class)
    @GET
    @Path("setting/{host}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getDeviceSetting(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                              @JaxrsParameterDescribe("设备IP") @PathParam("host") String host) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionHwDeviceSetting().execute(request, effectivePerson, host);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "获取设备信息", action = ActionHwDeviceInfo.class)
    @GET
    @Path("info/{host}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getDeviceInfo(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                                 @JaxrsParameterDescribe("设备IP") @PathParam("host") String host) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionHwDeviceInfo().execute(request, effectivePerson, host);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

    @JaxrsMethodDescribe(value = "获取设备管理列表", action = ActionHwDeviceManager.class)
    @GET
    @Path("manager/{host}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void getManager(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                              @JaxrsParameterDescribe("设备IP") @PathParam("host") String host) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionHwDeviceManager().execute(request, effectivePerson, host);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }


    @JaxrsMethodDescribe(value = "同步设备时间", action = ActionHwDeviceSyncTime.class)
    @GET
    @Path("syncTime/{host}")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void syncTime(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                           @JaxrsParameterDescribe("设备IP") @PathParam("host") String host) {
        ActionResult<String> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            Date hitDate = null;
            result = new ActionHwDeviceSyncTime().execute(request, effectivePerson, host, null);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }


}