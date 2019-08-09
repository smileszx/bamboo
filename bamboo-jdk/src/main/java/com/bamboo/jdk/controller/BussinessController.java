package com.bamboo.jdk.controller;

import com.bamboo.jdk.service.BusinessService;
import com.bamboo.jdk.service.impl.CalculatePolicyA;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/9 11:53
 **/
public class BussinessController {

    private static CyclicBarrier barrier;

    private static BusinessService businessService;

    private static volatile SortedMap<Long, String> map = Collections.synchronizedSortedMap(new TreeMap<>());

    public static void main(String[] args) {

        barrier = new CyclicBarrier(1, new Calculate());

        Thread t1 = new Thread(() -> {

            businessService = new CalculatePolicyA();
            String msg = businessService.service("A");
            System.out.println(msg);
            map.put(System.currentTimeMillis(), msg);
            try {
                barrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "服务调用线程");

        Thread t2 = new Thread(() -> {

            businessService = new CalculatePolicyA();
            String msg = businessService.service("B");
            map.put(System.currentTimeMillis(), msg);
            System.out.println(msg);

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "服务调用线程");

        Thread t3 = new Thread(() -> {

            businessService = new CalculatePolicyA();
            String msg = businessService.service("C");
            map.put(System.currentTimeMillis(), msg);
            System.out.println(msg);

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "服务调用线程");



        t1.start();
        t2.start();
        t3.start();
        
    }

    static class Calculate implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", 已经有服务返回计算结果， " + map.get(map.firstKey()));
        }
    }

}
