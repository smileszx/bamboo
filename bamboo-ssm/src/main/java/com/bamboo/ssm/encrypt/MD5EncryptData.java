package com.bamboo.ssm.encrypt;

import org.springframework.core.annotation.Order;

import java.security.MessageDigest;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/30 10:34
 **/
public class MD5EncryptData extends EncryptDataDecorator {

    public MD5EncryptData(SecurityResource securityResource) {
        super(securityResource);
    }

    @Override
    public String encrypt (String securityResource) {
        String init = super.encrypt(securityResource);
        System.out.println("md5加密前初始化: " + init);
        String encode = MD5(init);
        System.out.println("md5加密后: " + encode);
        return encode;
    }

    // MD5加码。32位
    private String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }
}
