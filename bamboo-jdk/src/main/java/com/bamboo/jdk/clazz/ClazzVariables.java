package com.bamboo.jdk.clazz;

/**
 * @Description
 * 类成员变量，需要static修饰，成员变量属于类，不属于任何一个类的实例
 * @Author victor su
 * @Date 2019/10/29 16:31
 **/
public class ClazzVariables {
    private int id;

    private static int numberOfClazz = 0;

    //常量
    /**
     * The static modifier, in combination with the final modifier, is also used to define constants.
     * The final modifier indicates that the value of this field cannot change.
     *
     * final关键字修饰的变量不能被修改，同时在声明时就需要初始化。
     * 声明为常量，变量名需要全部大写，多个单词组合时用下划线'_'分割
     */
    private static final double PI = 3.141592653;

    public ClazzVariables () {
        this.id = ++numberOfClazz;
    }

    public int getId() {
        return id;
    }

    /**
     * https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html
     * 类方法无法直接调用实例变量或实例方法，需要通过对象引用才能调用。
     * 当然类方法也无法通过this关键字调用，因为this关键字没有指向具体实例
     * Class methods cannot access instance variables or instance methods directly—they
     * must use an object reference. Also, class methods cannot use the this keyword as
     * there is no instance for this to refer to.
     * @return
     */
    public static int getNumberOfClazz() {
        return numberOfClazz;
    }
}
