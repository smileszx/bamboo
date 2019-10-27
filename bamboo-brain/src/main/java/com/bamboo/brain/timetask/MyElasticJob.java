package com.bamboo.brain.timetask;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Description
 * 自定义定时任务
 * @Author victor su
 * @Date 2019/10/27 16:01
 **/
public class MyElasticJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {

        switch (shardingContext.getShardingItem()) {
            case 0:
                System.out.println("我是分片0");
                break;
            case 1:
                System.out.println("我是分片1");
                break;
            case 2:
                System.out.println("我是分片2");
                break;
            case 3:
                System.out.println("我是分片3");
                break;
            case 4:
                System.out.println("我是分片4");
                break;
            case 5:
                System.out.println("我是分片5");
                break;
            default:
                System.out.println("默认分片");
                break;
        }

    }
}
