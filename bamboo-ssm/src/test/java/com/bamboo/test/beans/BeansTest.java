package com.bamboo.test.beans;

import com.bamboo.ssm.config.DBConfig;
import com.bamboo.ssm.config.JavaConfig;
import com.bamboo.ssm.temp.Panda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void test () {
        panda.eat();
    }

    @Test
    public void testDB () {
        dbConfig.getProperties();
    }

}
