package com.bamboo.ssm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 20:07
 **/
@Configuration
@PropertySource("classpath:db.properties")
public class DBConfig {

    @Autowired
    private Environment env;

    public void getProperties () {
        System.out.println(env.getProperty("jdbc.driver"));
        System.out.println(env.getProperty("jdbc.url"));
        System.out.println(env.getProperty("jdbc.username"));
        System.out.println(env.getProperty("jdbc.password"));
    }
}
