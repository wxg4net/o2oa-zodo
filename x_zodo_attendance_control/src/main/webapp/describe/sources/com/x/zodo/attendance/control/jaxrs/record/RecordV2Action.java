package com.x.zodo.attendance.control.jaxrs.record;

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
import java.util.List;

@Path("record/v2")
@JaxrsDescribe("考勤设备V1更新系统时间接口")
public class RecordV2Action extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger(RecordV2Action.class);

    @JaxrsMethodDescribe(value = "获取设备记录", action = ActionRecordV2List.class)
    @POST
    @Path("list")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void queryList(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                        @JaxrsParameterDescribe("设备记录查询条件") JsonElement jsonElement) {
        ActionResult<List<ActionRecordV2List.Wo>> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionRecordV2List().execute(request, effectivePerson, jsonElement);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

}