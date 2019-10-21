package com.bamboo.ssm.encrypt;

/**
 * @Description
 * 加密装饰器
 * @Author victor su
 * @Date 2019/8/30 10:19
 **/
public abstract class EncryptDataDecorator implements SecurityResource{

    private SecurityResource securityResource;

    public EncryptDataDecorator(SecurityResource securityResource){
        this.securityResource = securityResource;
    }

    public String encrypt(String securityResource) {
        return this.securityResource.encrypt(securityResource);
    }
}
