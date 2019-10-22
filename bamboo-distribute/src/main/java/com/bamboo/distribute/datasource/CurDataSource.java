package com.bamboo.distribute.datasource;

import java.lang.annotation.*;

/**
 * @Description
 * 多数据源注解
 * @Author victor su
 * @Date 2019/10/22 22:31
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {

    String name() default "";
}
