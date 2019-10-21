package com.bamboo.ssm.config;

import com.bamboo.ssm.temp.Bamboo;
import com.bamboo.ssm.temp.BambooBean;
import com.bamboo.ssm.temp.Panda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 16:04
 **/
@Configuration
@Profile("prod")
public class JavaConfig {

    @Bean
    public Bamboo bambooBean() {
        return new BambooBean();
    }

    @Bean
    public Panda watchPanda (Bamboo bamboo) {
        return new Panda(bamboo);
    }


}

