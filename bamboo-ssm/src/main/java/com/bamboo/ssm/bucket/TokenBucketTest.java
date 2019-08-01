package com.bamboo.ssm.bucket;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description
 * 限流算法-令牌桶
 *
 * https://www.cnblogs.com/xuwc/p/9123078.html
 * @Author victor su
 * @Date 2019/7/31 23:54
 **/
public class TokenBucketTest {


    public static void main(String[] args) {

        List<Runnable> list = new ArrayList<>(100);

        Executor executor = Executors.newFixedThreadPool(2);

        for (int i=0; i<10000; i++) {
            Runnable task = ()->{
                System.out.println("用戶請求，請給我一個令牌。 " + System.currentTimeMillis());
            };
            list.add(task);
        }

        submitTasks(list, executor);

    }

    public static void submitTasks(List<Runnable> tasks, Executor executor) {
        RateLimiter limiter = RateLimiter.create(2);
        for(Runnable task : tasks) {
            System.out.println(limiter.acquire(2));
            System.out.println(limiter.acquire());
            executor.execute(task);
        }
    }

}
