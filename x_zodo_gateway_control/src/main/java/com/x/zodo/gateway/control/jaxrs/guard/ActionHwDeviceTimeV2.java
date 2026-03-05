package com.x.zodo.gateway.control.jaxrs.guard;

import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.zodo.gateway.control.jaxrs.BaseAction;
import org.apache.commons.net.telnet.TelnetClient;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class ActionHwDeviceTimeV2 extends BaseAction {

    private static Logger logger = LoggerFactory.getLogger( ActionHwDeviceTimeV2.class );

    protected ActionResult<String> execute(HttpServletRequest request, EffectivePerson effectivePerson, String host, String time ) throws Exception {
        ActionResult<String> result = new ActionResult<>();

        String commandTimeTemplate = "{\"RETURN\": \"GetRequest\", \"PARAM\": {\"result\": \"success\", \"reason\": \"\", \"command\": \"SyncTime\", \"time\": \"%s\"}}";
        int timeoutMillis = 1000;
        String command = String.format(commandTimeTemplate, time);
        String port = "9922";
        byte[] commandBytes = command.getBytes(StandardCharsets.UTF_8);
        int length = commandBytes.length;

        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);  // 大端模式
        buffer.putInt(length);
        byte[] lengthPrefix = buffer.array();
        TelnetClient telnetClient = new TelnetClient();
        try {
            telnetClient.setConnectTimeout(timeoutMillis);
            telnetClient.connect(host, Integer.parseInt(port));

            InputStream inputStream = telnetClient.getInputStream();
            OutputStream outputStream = telnetClient.getOutputStream();
            logger.info("command => {}", command);
            outputStream.write(lengthPrefix);
            outputStream.write(commandBytes);
            outputStream.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
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
