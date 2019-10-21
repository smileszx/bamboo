package com.bamboo.ssm.config;

import com.bamboo.ssm.temp.Animal;
import com.bamboo.ssm.temp.Bamboo;
import com.bamboo.ssm.temp.BambooBean;
import com.bamboo.ssm.temp.Panda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 11:11
 **/
@Configuration
//包扫描配置，可以配置多个包路径，但是考虑代码重构有可能导致有些类改变包路径，
// 产生不安全的问题，可以考虑在指定包中创建maker interface作为标记接口，以上考虑仅供参考
//@ComponentScan(basePackages = "com.bamboo.ssm.temp")
@ComponentScan(basePackageClasses = Animal.class)
@Profile("dev")
public class BeanConfig {

    @Bean
    public Bamboo bamboo() {
        return new BambooBean();
    }
    @Bean
    public Panda panda() {
        return new Panda(bamboo());
    }
}
