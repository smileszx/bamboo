package com.bamboo.ssm.temp;

import com.bamboo.ssm.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/15 23:57
 **/
public class JavaBean {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/java-bean.xml");
//
//        BambooBean bambooBean = (BambooBean) ctx.getBean("bambooBean");
//
//        bambooBean.show("who are you?");
//
//        Panda panda = (Panda) ctx.getBean("panda");
//        panda.eat();

        ApplicationContext annotationCtx = new AnnotationConfigApplicationContext(BeanConfig.class);

        Bamboo bamboo = (BambooBean)annotationCtx.getBean("bamboo");
        bamboo.show("hello");

        Panda panda =(Panda) annotationCtx.getBean("panda");
        panda.eat();

    }
}
