package com.bamboo.ssm.aop.pojo;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 11:01
 **/
@Component
public class CriticismEngineImpl implements CriticismEngine {

    public CriticismEngineImpl() {}

    @Override
    public String getCriticism(){
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    private String [] criticismPool;

    public void setCriticismPool(String [] criticismPool){
        this.criticismPool = criticismPool;
    }
}
