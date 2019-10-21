package com.bamboo.ssm.encrypt;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/30 11:07
 **/
public class BASE64EncryptData extends EncryptDataDecorator{


    public BASE64EncryptData(SecurityResource securityResource) {
        super(securityResource);
    }

    @Override
    public String encrypt (String securityResource) {
        String init = super.encrypt(securityResource);
        System.out.println("base64加密前初始化：" + init);
        String encode = getBASE64(init);
        System.out.println("base64加密后: " + encode);
        return encode;
    }

    private String getBASE64(String s) {
        if (s == null)
            return null;
        return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
    }
}
