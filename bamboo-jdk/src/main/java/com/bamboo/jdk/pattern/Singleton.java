package com.bamboo.jdk.pattern;

public class Singleton
{

    private static Singleton singleton = new Singleton();

    private Singleton(){}
    
    static {
        System.out.println("This's static code block!");
    }

    /**
     * 内部静态类
     */
    private static class SingletonHandler {
        // 注意：内部类中变量如果想设置成静态属性，那么该内部类必须为静态类
        // 原因是静态属性和方法是随着类加载而存在的，非静态内部类在外部类加载时不会被加载，
        // 因此非静态内部类中不能包含静态属性和方法
        private static Singleton singleton = new Singleton();

        private static int temp;

        static {
            System.out.println("This's innerClass's static code block");
        }
        public static void test() {
            System.out.println("This is innerClass's static method. 静态变量temp: " + temp);
        }
    }
    
    public static Singleton getInstance(){
        return SingletonHandler.singleton;
    }
    
    public static void display(){
        System.out.println("This's display!");
    }
}