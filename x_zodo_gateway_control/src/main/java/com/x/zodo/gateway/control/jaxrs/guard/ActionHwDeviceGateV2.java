package com.x.zodo.gateway.control.jaxrs.guard;

import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.gateway.control.jaxrs.BaseAction;
import org.apache.commons.net.telnet.TelnetClient;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class ActionHwDeviceGateV2 extends BaseAction {

    private static Logger logger = LoggerFactory.getLogger( ActionHwDeviceGateV2.class );

    protected ActionResult<String> execute(HttpServletRequest request, EffectivePerson effectivePerson, String host, String time ) throws Exception {
        ActionResult<String> result = new ActionResult<>();
        String commandTimeTemplate = "SetDeviceInfo(time=\"%s\" week=\"1\")\n";
        int timeoutMillis = 1000;
        String command = String.format(commandTimeTemplate, time);
        String encoding = "GB18030";
        String port = "9922";
        TelnetClient telnetClient = new TelnetClient();
        try {
            telnetClient.setConnectTimeout(timeoutMillis);
            telnetClient.connect(host, Integer.parseInt(port));

            InputStream inputStream = telnetClient.getInputStream();
            OutputStream outputStream = telnetClient.getOutputStream();
            logger.info("command => {}", command);
            outputStream.write(command.getBytes());
            outputStream.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, encoding));
            telnetClient.setSoTimeout(timeoutMillis);

            StringBuilder stringBuilder = new StringBuilder();
            int ch;
            try {
                while ((ch = bufferedReader.read()) != -1) {
                    stringBuilder.append((char) ch);
                }
            } catch (Exception e) {
                 // logger.error(e);
            }
            result.setData(stringBuilder.toString());
        } catch (IOException e) {
             // logger.error(e);
        } finally {
            try {
                telnetClient.disconnect();
            } catch (IOException e) {
                // logger.error(e);
            }
        }

        return result;
    }

}
