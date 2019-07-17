package com.bamboo.ssm.config;

import com.bamboo.ssm.aop.advice.Audience;
import com.bamboo.ssm.aop.advice.AudienceAround;
import com.bamboo.ssm.aop.advice.EncoreableInroducer;
import com.bamboo.ssm.aop.advice.TrackCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 8:07
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.bamboo.ssm.aop")
public class AOPConfig {

    @Bean
    public Audience audience(){
        return new Audience();
    }

    @Bean
    public AudienceAround audienceAround() {
        return new AudienceAround();
    }

    @Bean
    public TrackCounter trackCounter () {
        return new TrackCounter();
    }

    @Bean
    public EncoreableInroducer encoreableInroducer () {
        return new EncoreableInroducer();
    }
}
