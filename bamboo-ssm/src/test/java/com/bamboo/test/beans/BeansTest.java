package com.bamboo.test.beans;

import com.bamboo.ssm.config.BeanConfig;
import com.bamboo.ssm.config.DBConfig;
import com.bamboo.ssm.config.JavaConfig;
import com.bamboo.ssm.temp.Animal;
import com.bamboo.ssm.temp.Panda;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 12:35
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaConfig.class, DBConfig.class})
@ActiveProfiles("prod")
public class BeansTest {
    @Autowired
    private Panda panda;
    @Autowired
    private DBConfig dbConfig;
////    @Resource
//    private Animal animal;

//    @Test
//    public void rabbitShouldNotNull () {
//        assertNotNull(animal);
//        animal.introduce();
//        System.out.println(animal.getClass().getName());
//    }

    @Test
    public void test () {
        panda.eat();
    }

    @Test
    public void testDB () {
        dbConfig.getProperties();
    }

}
