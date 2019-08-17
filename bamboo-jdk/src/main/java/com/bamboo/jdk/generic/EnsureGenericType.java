package com.bamboo.jdk.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/17 14:50
 **/
public class EnsureGenericType {


    public static void main(String[] args) {
        //不能实例化参数化类型的数组，擦除之后table的类型是Pair[],可以将其转换为Object[]
        Pair [] table = new Pair[10];
        table[0] = new Pair<String>();


        Pair<String>[] pair = (Pair<String>[]) new Pair<?>[10];


    }

//    @SafeVarargs
    public static <T> void addAll(Collection<T> coll, T... ts) {
        for(T t : ts) coll.add(t);
    }


    public static <T extends Comparable> T minElement(T[] a){
        if (a == null || a.length == 0)
            return null;
        T smallest = a[0];
        for(int i = 1; i<a.length; i++)
            if(smallest.compareTo(a[i]) > 0)
                smallest = a[i];
        return smallest;
    }
}
