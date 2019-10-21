package com.bamboo.ssm.encrypt;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/30 10:45
 **/
public class EncryptClient {

    public static void main(String[] args) {
        String origin = "Hello World";

        SecurityResource resource = new SecurityResourceInit();

        resource = new MD5EncryptData(resource);

        resource = new BASE64EncryptData(resource);

        String encode = resource.encrypt(origin);

        System.out.println("数据加密结果: " + encode);
    }
}
