package com.x.zodo.attendance.control.jaxrs.device.v2;

import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.jaxrs.WoValue;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.attendance.control.hanvon.v2.CommandHelper;
import com.x.zodo.attendance.control.hanvon.v2.CommandTemplate;
import com.x.zodo.attendance.control.jaxrs.BaseAction;
import javax.servlet.http.HttpServletRequest;

public class ActionHwDeviceDoorControl extends BaseAction {

    // 0门常闭，1门常开，-1解除限制

    private static Logger logger = LoggerFactory.getLogger( ActionHwDeviceDoorControl.class );

    protected ActionResult<String> execute(HttpServletRequest request, EffectivePerson effectivePerson, String host, Integer status) throws Exception {
        ActionResult<String> result = new ActionResult<>();
        CommandTemplate commandTemplate = new CommandTemplate("SetDoorStatus");
        commandTemplate.setParam("status", status);
        commandTemplate.setParam("result", "success");
        commandTemplate.setParam("reason", "");
        String response = CommandHelper.send(host, commandTemplate);
        result.setData(response);
        return result;
    }

    public static class Wo extends WoValue {
        public Wo(String value) {
            setValue(value);
        }
    }
}
