package com.x.zodo.attendance.control.jaxrs.device.v1;

import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.jaxrs.StandardJaxrsAction;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.attendance.control.hanvon.v1.CommandHelper;
import org.apache.commons.net.telnet.TelnetClient;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class ActionDeviceTime extends StandardJaxrsAction {

    private static Logger logger = LoggerFactory.getLogger( ActionDeviceTime.class );

    protected ActionResult<String> execute(HttpServletRequest request, EffectivePerson effectivePerson, String host, String time ) throws Exception {
        ActionResult<String> result = new ActionResult<>();
        String commandTemplate = "SetDeviceInfo(time=\"%s\" week=\"1\")\n";
        String response = CommandHelper.send(host, String.format(commandTemplate, time));
        result.setData(response);
        return result;
    }

}
