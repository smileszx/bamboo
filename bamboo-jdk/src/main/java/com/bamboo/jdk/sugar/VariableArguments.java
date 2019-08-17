package com.bamboo.jdk.sugar;

/**
 * @Description
 * 语法糖：可变参数
 * @Author victor su
 * @Date 2019/8/17 22:49
 **/
public class VariableArguments {
    public static void main(String[] args) {

        testVA("a", "b", "c", "d", "e", "f", "g");
    }

    public static void testVA (String... strings) {

        for(int i=0; i<strings.length; i++) {
            System.out.println(String.join(" : ", "参数-"+i, strings[i]));
        }
    }
}
