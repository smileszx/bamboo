package com.bamboo.jdk.service.impl;

import com.bamboo.jdk.CommonUtil;
import com.bamboo.jdk.service.BusinessService;

import java.util.Random;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/9 11:42
 **/
public class CalculatePolicyB implements BusinessService {

    private static final Random random = new Random(1);

    @Override
    public String service(String param) {

        //数据处理过程
        long start = System.currentTimeMillis();
        CommonUtil.sleep(random.nextInt(10000));

        return String.join("_", Thread.currentThread().getName(),
                " finish the calculate. cost", (System.currentTimeMillis()-start)+"ms");
    }
}
