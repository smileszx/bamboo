package com.bamboo.test.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/7 12:43
 **/
public class HashtableTest {

    @Test
    public void testPut () {

        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();

        // Hashtable K和V 均不能为空，否则抛出NPE异常
        // java.lang.NullPointerException
        //	at java.util.Hashtable.put(Hashtable.java:460)
        hashtable.put(null, null);
        hashtable.put(1, null);
        hashtable.put(null, 2);

    }

    @Test
    public void testPutSpeed () {
        int max = 10000000;

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        long start = System.currentTimeMillis();
        for(int i=0; i<max; i++) {
            hashtable.put(i, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("hashtable cost: " + (end-start) + " ms");

        System.out.println("===================== 华丽分割线 =========================");

        Map<Integer, Integer> treeMap = new TreeMap<>();
        long start_treemap = System.currentTimeMillis();
        for(int i=0; i<max; i++) {
            treeMap.put(i, i);
        }
        long end_treemap = System.currentTimeMillis();
        System.out.println("treemap cost: " + (end_treemap-start_treemap) + " ms");

        System.out.println("===================== 华丽分割线 =========================");

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        long start_hashmap = System.currentTimeMillis();
        for(int i=0; i<max; i++) {
            hashMap.put(i, i);
        }
        long end_hashmap = System.currentTimeMillis();
        System.out.println("hashmap cost: " + (end_hashmap-start_hashmap) + " ms");

        System.out.println("===================== 华丽分割线 =========================");

        Map<Integer, Integer> conHashMap = new ConcurrentHashMap<>();
        long start_chashmap = System.currentTimeMillis();
        for(int i=0; i<max; i++) {
            conHashMap.put(i, i);
        }
        long end_chashmap = System.currentTimeMillis();
        System.out.println("concurrenthashmap cost: " + (end_chashmap-start_chashmap) + " ms");

    }

}
