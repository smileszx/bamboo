package com.bamboo.jdk.generic;

import java.lang.reflect.Array;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/17 14:30
 **/
public class Pair <T> {

    private T first;

    private T second;

    public Pair() {}

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T> Pair<T> makePair(Supplier<T> constr) {
        return new Pair<>(constr.get(), constr.get());
    }

    public static <T> Pair<T> makePair(Class<T> cl) {
        try {
            return new Pair<>(cl.newInstance(), cl.newInstance());
        } catch (Exception e) {
            return null;
        }
    }

    public static <T extends Comparable> T[] minmax (IntFunction<T[]> constr, T... a) {
        T[] mm = constr.apply(2);

        return mm;
    }

    public static <T extends Comparable> T[] minmax (T... a) {
        T[] mm = (T[]) Array.newInstance(a.getClass(), 2);

        return mm;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }


    public <T> T getFirstElement () {

        return (T) this.first;
    }
}
