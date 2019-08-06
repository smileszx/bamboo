package com.bamboo.test.map;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description
 * VIPKID面试，来自百度的一个面试官问到TreeMap的原理及特点
 *
 * TreeMap 强关联的Java知识点
 * 红黑树
 *
 * @Author victor su
 * @Date 2019/8/6 17:28
 **/
public class TreeMapTest {


    @Test
    public void testTreeMapPut () {
        //TreeMap无参构造函数，比较器默认为null，此时添加到TreeMap中的元素会按照key值的自然顺序排序。
//        Map<Integer, String> treeMap = new TreeMap<>();


        //自定义Comparator
        Map<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        treeMap.put(31, "a");
        treeMap.put(1, "b");
        treeMap.put(11, "c");
        treeMap.put(25, "d");
        treeMap.put(5, "e");
        treeMap.put(6, "f");
        treeMap.put(99, "g");
        treeMap.put(55, "h");
        treeMap.put(88, "i");
        treeMap.put(2, "j");
        treeMap.put(78, "k");
        treeMap.put(90, "l");

        treeMap.put(100, "m");


        System.out.println(treeMap);

    }


}
