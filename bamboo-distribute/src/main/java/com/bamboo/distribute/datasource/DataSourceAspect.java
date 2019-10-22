package com.bamboo.distribute.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description
 * 多数据源切面处理
 * @Author victor su
 * @Date 2019/10/22 22:38
 **/
@Aspect
@Component
public class DataSourceAspect implements Ordered {


    @Pointcut("@annotation(com.bamboo.distribute.datasource.CurDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CurDataSource dataSource = method.getAnnotation(CurDataSource.class);
        if (dataSource == null) {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER);
        } else {
            DynamicDataSource.setDataSource(DataSourceEnum.SLAVE);
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
