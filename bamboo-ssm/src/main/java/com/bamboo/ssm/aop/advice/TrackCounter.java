package com.bamboo.ssm.aop.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/17 8:46
 **/
//@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();

    @Pointcut("execution(* com.bamboo.ssm.aop.pojo.Performance.recordOrder(int)) && args(trackNumber)")
    public void trackPlayed(int trackNumber){}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber){
        int current = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, current + 1);
    }

    public Integer getPlayCount (int trackeNumber){
        return trackCounts.containsKey(trackeNumber) ? trackCounts.get(trackeNumber) : 0;
    }
}
