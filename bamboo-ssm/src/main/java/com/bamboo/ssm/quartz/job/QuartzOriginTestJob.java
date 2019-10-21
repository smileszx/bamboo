package com.bamboo.ssm.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/28 18:36
 **/
public class QuartzOriginTestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Quartz官方任务调度测试");
    }
}
