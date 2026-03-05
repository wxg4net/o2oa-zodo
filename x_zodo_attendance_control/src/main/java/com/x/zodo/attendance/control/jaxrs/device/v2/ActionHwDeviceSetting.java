package com.x.zodo.attendance.control.jaxrs.device.v2;

import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.attendance.control.hanvon.v2.CommandHelper;
import com.x.zodo.attendance.control.hanvon.v2.CommandTemplate;
import com.x.zodo.attendance.control.jaxrs.BaseAction;

import javax.servlet.http.HttpServletRequest;

public class ActionHwDeviceSetting extends BaseAction {

    private static Logger logger = LoggerFactory.getLogger( ActionHwDeviceSetting.class );

    protected ActionResult<String> execute(HttpServletRequest request, EffectivePerson effectivePerson, String host) throws Exception {
        ActionResult<String> result = new ActionResult<>();
        CommandTemplate commandTemplate = new CommandTemplate("GetDeviceParameter");
        String response = CommandHelper.send(host, commandTemplate);
        result.setData(response);
        return result;
    }

}
