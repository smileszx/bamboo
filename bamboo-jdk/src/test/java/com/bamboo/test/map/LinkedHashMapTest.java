package com.bamboo.test.map;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/11 13:54
 **/
public class LinkedHashMapTest {

    @Test
    public void testLinkedHashMapOrder () {

        Map<Integer, Integer> insertOrderMap = new LinkedHashMap<>();

        insertOrderMap.put(1, 1);
        insertOrderMap.put(2, 2);
        insertOrderMap.put(3, 3);

        System.out.println("default insert order: " + insertOrderMap);

        insertOrderMap.put(2, 2);

        System.out.println("insert order after put : " + insertOrderMap);



        Map<Integer, Integer> accessOrderMap = new LinkedHashMap<Integer, Integer>(3, 0.75f,true);

        accessOrderMap.put(1, 1);
        accessOrderMap.put(2, 2);
        accessOrderMap.put(3, 3);

        System.out.println("default access order: " + accessOrderMap);

        accessOrderMap.get(2);

        System.out.println("access order after put : " + accessOrderMap);


    }
}
