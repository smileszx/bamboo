package com.bamboo.test.beans;

import com.bamboo.ssm.annotation.Rabbit;
import com.bamboo.ssm.temp.Animal;
import com.bamboo.ssm.temp.Panda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 17:22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/java-bean.xml"})
public class XmlContexTest {

    @Resource(name = "tiger")
    private Animal tiger;

    @Autowired
    @Rabbit
    private Animal rabbit;

    @Inject
    private Panda panda;

    @Test
    public void tigerTest() {
        //Animal是接口,Rabbit 和 Tiger 是Animal的实现类，
        //如果注入时采用Animal接口，那么不能用byType方式注入，
        // 因为Animal有多个实现类，需要通过byName指定注入哪个实现类
        tiger.introduce();
        rabbit.introduce();
        System.out.println(tiger);
        System.out.println(tiger);
    }

    @Test
    public void panda() {
        panda.eat();
        panda.friend();
    }
}
