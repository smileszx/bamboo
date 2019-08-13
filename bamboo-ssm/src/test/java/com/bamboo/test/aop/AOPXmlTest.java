package com.bamboo.test.aop;

import com.bamboo.ssm.aop.pojo.CrossTalk;
import com.bamboo.ssm.aop.pojo.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 10:25
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/java-bean.xml")
public class AOPXmlTest {
    @Autowired
    @Qualifier("singPerformance")
    private Performance performance;
    @Test
    public void testXmlAddFunction(){
        performance.perform();
        ((CrossTalk) performance).play();
    }

//    @Test
    public void testCriticism () {
        performance.perform();
    }
}
