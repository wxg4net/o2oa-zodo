package com.x.zodo.attendance.control.hanvon.v2;

import com.x.zodo.attendance.control.hanvon.InvalidPasswordException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class HanvonCrypto {

    private String password;
    private byte[] key = new byte[8];  // 固定8字节的密钥表

    public HanvonCrypto(String password) throws InvalidPasswordException {
        setPassword(password);
    }

    /**
     * 加密和解密使用完全相同的算法（对称可逆）
     */
    public byte[] convert(byte[] data, int offset) {
        byte[] result = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            // Java中 byte 是 signed，需要 & 0xFF 转为 0~255 的无符号值处理
            int byteVal = data[i] & 0xFF;
            int converted = convertCharFromByte(byteVal, i + offset);
            result[i] = (byte) converted;
        }

        return result;
    }

    public byte[] convert(String message, int offset) {
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        return convert(data, offset);
    }

    // 方便调用：默认 offset = 0
    public byte[] convert(byte[] data) {
        return convert(data, 0);
    }

    public byte[] convert(String message) {
        return convert(message, 0);
    }

    // 加密 = 解密（算法对称）
    public byte[] encrypt(byte[] data, int offset) {
        return convert(data, offset);
    }

    public byte[] encrypt(String message, int offset) {
        return convert(message, offset);
    }

    public byte[] encrypt(byte[] data) {
        return convert(data, 0);
    }

    public byte[] encrypt(String message) {
        return convert(message, 0);
    }

    public byte[] decrypt(byte[] data, int offset) {
        return convert(data, offset);
    }

    public byte[] decrypt(byte[] data) {
        return convert(data, 0);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        if (isValidPassword(password)) {
            this.password = password;
            computeKey();
        } else {
            throw new InvalidPasswordException("Password must be 1 to 8 digits");
        }
    }

    // ================== 核心转换逻辑 ==================

    private int convertCharFromByte(int byteVal, int pos) {
        return byteVal ^ (key[pos % 8] & 0xFF);
    }

    private boolean isValidPassword(String password) {
        if (password == null) return false;
        return Pattern.matches("^\\d{1,8}$", password);
    }

    private void computeKey() {
        for (int i = 0; i < 8; i++) {
            int charValue = (i < password.length())
                    ? password.charAt(i)
                    : 0;

            // 2**i >> 1 即 1 << (i-1) ，当 i=0 时为 0
            int shiftPart = (i == 0) ? 0 : (1 << (i - 1));

            key[i] = (byte) (charValue + shiftPart);
        }
    }
}
