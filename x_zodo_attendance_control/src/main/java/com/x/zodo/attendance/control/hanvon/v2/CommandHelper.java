package com.x.zodo.attendance.control.hanvon.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class CommandHelper {
    public static String port = "9922";
    public static int connectionTimeout = 1000;
    public static int socketTimeout = 1000;
    public static ObjectMapper mapper = new ObjectMapper();

    public static String send( String host, CommandTemplate cmdTpl) throws Exception {
        return send(host, port, cmdTpl);
    }
    public static String send( String host, String port, CommandTemplate cmdTpl) throws Exception {
        String command = mapper.writeValueAsString(cmdTpl);
        byte[] commandBytes = command.getBytes(StandardCharsets.UTF_8);
        int length = commandBytes.length;
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(length);
        byte[] lengthPrefix = buffer.array();
        HanvonCrypto crypto = new HanvonCrypto("123456");
        if (!"SetCommunicationPassword".equals(cmdTpl.getCommand())) {
            commandBytes = crypto.convert(commandBytes);
        }
        TelnetClient telnetClient = new TelnetClient();
        try {
            telnetClient.setConnectTimeout(connectionTimeout);
            telnetClient.connect(host, Integer.parseInt(port));
            InputStream inputStream = telnetClient.getInputStream();
            OutputStream outputStream = telnetClient.getOutputStream();
            outputStream.write(lengthPrefix);
            outputStream.write(commandBytes);
            outputStream.flush();

            telnetClient.setSoTimeout(socketTimeout);
            DataInputStream din = new DataInputStream(inputStream);
            int expectedLength = din.readInt();  // Java 的 readInt() 默认就是大端序（网络字节序）

            if (expectedLength < 0 || expectedLength > 10_000_000) {
                throw new IOException("不合理的长度值: " + expectedLength);
            }
            // 2. 读取完整 payload（正好 expectedLength 字节）
            byte[] responseBody = new byte[expectedLength];
            int totalRead = 0;

            while (totalRead < expectedLength) {
                int bytesRead = din.read(responseBody, totalRead, expectedLength - totalRead);
                if (bytesRead < 0) {
                    throw new IOException("连接在接收过程中断开，已读 " + totalRead + "/" + expectedLength + " 字节");
                }
                totalRead += bytesRead;
            }
            byte[] decrypted = crypto.decrypt(responseBody);

            try {
                return new String(decrypted, StandardCharsets.UTF_8);
            } catch (Exception decodeEx) {
                decodeEx.printStackTrace();
            }
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
