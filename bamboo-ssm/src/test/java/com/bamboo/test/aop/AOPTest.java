package com.bamboo.test.aop;

import com.bamboo.ssm.aop.advice.EncoreableInroducer;
import com.bamboo.ssm.aop.advice.TrackCounter;
import com.bamboo.ssm.aop.pojo.DefaultEncoreable;
import com.bamboo.ssm.aop.pojo.Encoreable;
import com.bamboo.ssm.aop.pojo.Performance;
import com.bamboo.ssm.config.AOPConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 12:34
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AOPConfig.class)
public class AOPTest {

    @Autowired
    @Qualifier("singPerformance")
    private Performance performance;

    @Autowired
    private TrackCounter trackCounter;

    @Autowired
    private DefaultEncoreable encoreable;

//    @Test
    public void testPerformance () {
        performance.perform();
    }

//    @Test
    public void testTrackCounter() {

        performance.recordOrder(1);
        performance.recordOrder(1);
        performance.recordOrder(1);
        performance.recordOrder(1);

        performance.recordOrder(5);
        performance.recordOrder(5);
        performance.recordOrder(5);

        Integer sing1 = trackCounter.getPlayCount(1);

        Integer sing5 = trackCounter.getPlayCount(5);

        System.out.println(sing1);
        System.out.println(sing5);


    }

//    @Test
    public void testEncore(){
        Object object = new Object();
        performance.perform();
        ((Encoreable) performance).performEncore();
    }
}
