package com.bamboo.jdk.generic;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * PECS原则
 * - 频繁往外读取内容的，适合用上界Extends。
 * - 经常往里插入的，适合用下界Super。
 * https://www.cnblogs.com/drizzlewithwind/p/6100164.html
 * @Author victor su
 * @Date 2019/8/17 11:55
 **/
public class GenericTest {

    public static void main(String[] args) {
        testExtends();
    }

    public static void testExtends () {
        Zoo<? extends Hashiqi> zooArr = new Zoo<>(new Hashiqi());

//        zooArr.setItem(new Animal());

        Animal item = zooArr.getItem();
        System.out.println(item);
    }

    public static void testSuper () {
        Zoo<? super Dog> zooArr = new Zoo<>();

        zooArr.setItem(new Dog());
        // 下界通配符不影响，set数据，影响get
//        zooArr.setItem(new Animal());
        zooArr.setItem(new Hashiqi());


        Dog dog = (Dog) zooArr.getItem();
        System.out.println(dog);


    }

    public static void testGeneric() {

        Pair<String> pair = new Pair<>("first", "second");

        System.out.println((String) pair.getFirstElement());
    }

    //List 不使用泛型，不限制对象类型，什么都扔到容器中，那么请问你知道取出来的是什么么？
    public static void testListAnyType () {
        List anyList = new ArrayList();

        anyList.add(new Object());

        anyList.add(new Date());

        anyList.add(1);

        anyList.add("generic");

        Integer s = (Integer) anyList.get(anyList.size()-1);
        System.out.println("获取最后一个元素： " + s);

        for (int i=0; i<anyList.size(); i++) {
            System.out.println(anyList.get(i));
        }


        Stack stack = new Stack();

        stack.push(3);
        stack.push(new Object());
        stack.push("stack");
        System.out.println(stack.peek());


    }


}
