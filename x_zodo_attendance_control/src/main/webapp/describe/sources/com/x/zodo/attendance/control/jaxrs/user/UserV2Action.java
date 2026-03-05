package com.x.zodo.attendance.control.jaxrs.user;

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
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("user/v2")
@JaxrsDescribe("考勤设备V1更新系统时间接口")
public class UserV2Action extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger(UserV2Action.class);

    @JaxrsMethodDescribe(value = "获取用户信息记录", action = ActionUser.class)
    @POST
    @Path("info")
    @Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
    @Consumes(MediaType.APPLICATION_JSON)
    public void queryList(@Suspended final AsyncResponse asyncResponse, @Context HttpServletRequest request,
                          @JaxrsParameterDescribe("用户名称") String name) {
        ActionResult<List<ActionUser.Wo>> result = new ActionResult<>();
        EffectivePerson effectivePerson = this.effectivePerson(request);
        try {
            result = new ActionUser().execute(request, effectivePerson, name);
        } catch (Exception e) {
            result.error(e);
        }
        asyncResponse.resume(ResponseFactory.getEntityTagActionResultResponse(request, result));
    }

}