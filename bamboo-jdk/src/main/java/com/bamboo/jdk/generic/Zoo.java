package com.bamboo.jdk.generic;

/**
 * @Description
 * 动物园
 * @Author victor su
 * @Date 2019/10/15 11:40
 **/
public class Zoo<T> {

    private T item;

    public Zoo() {}

    public Zoo (T item) {

        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
