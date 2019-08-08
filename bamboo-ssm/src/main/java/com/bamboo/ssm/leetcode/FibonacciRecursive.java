package com.bamboo.ssm.leetcode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * Fibonacci递归算法经典案例
 * 斐波那契数列（也称作兔子数列）  1,1,2,3,5,8,13,21,34...
 * @Author victor su
 * @Date 2019/8/8 23:00
 **/
public class FibonacciRecursive {
    private static volatile int invoke = 0;
    private static ConcurrentHashMap map = new ConcurrentHashMap();

    private static volatile int optimize = 0;

    public static void main(String[] args) {
        long origin_start = System.currentTimeMillis();
        int result = fibonacciRecursiveOrigin(42);
        long origin_end = System.currentTimeMillis();
        System.out.println(String.join("_", "原生计算次数: " + optimize, "计算结果: " + result, "计算耗时: " + (origin_end-origin_start) +"ms"));

        long opt_start = System.currentTimeMillis();
        int opt = fibonacciRecursive(42);
        long opt_end = System.currentTimeMillis();
        System.out.println(String.join("_", "优化后计算次数: " + invoke, "计算结果: " + opt, "计算耗时: " + (opt_end-opt_start) +"ms"));
    }


    /**
     * 斐波那契数列 优化方案
     * @param n
     * @return
     */
    public static int fibonacciRecursive(int n) {
        invoke ++;
        if(map.get(n) != null) {
            return (int) map.get(n);
        } else {
            if(n == 1 || n== 2) {
                map.put(n, 1);
                return 1;
            } else {
                map.put(n, fibonacciRecursive(n-1) + fibonacciRecursive(n-2));
                return (int) map.get(n);
            }
        }
    }

    /**
     * 斐波那契数列 经典解决方案
     *
     * @param n
     * @return
     */
    public static int fibonacciRecursiveOrigin(int n) {
        optimize ++;

        if(n == 1 || n== 2) {
            return 1;
        } else {
            return fibonacciRecursiveOrigin(n-1) + fibonacciRecursiveOrigin(n-2);
        }
    }


}
