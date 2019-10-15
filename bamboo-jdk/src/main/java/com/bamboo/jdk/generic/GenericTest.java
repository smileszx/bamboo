package com.bamboo.jdk.generic;

import java.lang.reflect.InvocationTargetException;
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
        testAfterErase();
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

    /**
     * 初始化定义泛型，运行期泛型被擦除，JVM中只保留List原始类型
     * https://www.cnblogs.com/wuqinglong/p/9456193.html
     */
    public static void testTypeErase() {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass());
    }

    public static void testAfterErase () {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        try {
            list.getClass().getMethod("add", Object.class).invoke(list, "asd");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
