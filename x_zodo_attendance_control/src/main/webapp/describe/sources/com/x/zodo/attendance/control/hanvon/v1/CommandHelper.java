package com.x.zodo.attendance.control.hanvon.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.x.zodo.attendance.control.hanvon.v2.CommandTemplate;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class CommandHelper {
    static String port = "9922";
    static int connectionTimeout = 1000;
    static int socketTimeout = 1000;
    static String encoding = "GB18030";

    public static String send( String host, String cmdTpl) throws Exception {
        return send(host, port, cmdTpl);
    }
    public static String send( String host, String port, String cmdTpl) throws Exception {
        byte[] commandBytes = cmdTpl.getBytes(StandardCharsets.UTF_8);
        TelnetClient telnetClient = new TelnetClient();
        try {
            telnetClient.setConnectTimeout(connectionTimeout);
            telnetClient.connect(host, Integer.parseInt(port));
            InputStream inputStream = telnetClient.getInputStream();
            OutputStream outputStream = telnetClient.getOutputStream();
            outputStream.write(commandBytes);
            outputStream.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, encoding));
            telnetClient.setSoTimeout(socketTimeout);
            StringBuilder stringBuilder = new StringBuilder();
            int ch;
            try {
                while ((ch = bufferedReader.read()) != -1) {
                    stringBuilder.append((char) ch);
                }
            } catch (Exception e) {
                // logger.error(e);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            // logger.error(e);
        } finally {
            try {
                telnetClient.disconnect();
            } catch (IOException e) {
                // logger.error(e);
            }
        }
        return null;
    }

}
