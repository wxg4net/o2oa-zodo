package com.x.zodo.attendance.control.jaxrs.device.v1;

import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.jaxrs.StandardJaxrsAction;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.attendance.control.hanvon.v1.CommandHelper;

import javax.servlet.http.HttpServletRequest;

public class ActionHwDeviceCommunication extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger( ActionHwDeviceCommunication.class );

    public ActionResult<String> execute(HttpServletRequest request, EffectivePerson effectivePerson
            , String ip, String netmask, String gateway, String commukey) throws Exception {
        ActionResult<String> result = new ActionResult<>();
        String commandTemplate = "SetNetInfo(ip=\"%s\" netmask=\"%s\" gateway=\"%s\"  commukey=\"%s\")\n";
        String response = CommandHelper.send(ip, String.format(commandTemplate, ip, netmask, gateway, commukey));
        result.setData(response);
        return result;
    }

}
