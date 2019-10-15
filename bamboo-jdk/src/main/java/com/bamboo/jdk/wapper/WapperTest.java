package com.bamboo.jdk.wapper;

/**
 * @Description
 * 包装类的拆箱装箱
 * @Author victor su
 * @Date 2019/10/15 22:41
 **/
public class WapperTest {


    public static void main(String[] args) {
        testInteger();
    }


    /**
     *  JVM会自动维护八种基本类型的常量池，int常量池中初始化-128~127的范围，
     *  所以当为Integer i=127时，在自动装箱过程中是取自常量池中的数值，
     *  而当Integer i=128时，128不在常量池范围内，所以在自动装箱过程中需new 128，所以地址不一样。
     * （1）Integer直接赋值时，若值在[-128,127]之间则不会申请新对象，会调用常量池中的对象；
     *
     * （2）若超过范围，则申请new一个对象；
     *
     * （3）若采用构造方法赋值，则在堆上开辟新空间；
     *
     * （4）Integer和int进行==比较时，由于会自动拆箱，将Integer转为int，则直接看值的大小就可以。
     */
    public static void testInteger () {
        //Integer -128~127之间的数据创建缓存，因此a和b是同一个对象
        Integer a = 10;
        Integer b = 10;
        System.out.println(String.format("%s == %s, %s", a, b, a==b));

        //Integer -128~127之间的数据创建缓存，因此a1和b1没有缓存，因此为不同的对象
        //-Djava.lang.Integer.IntegerCache.high=1250 VM参数可以修改缓存阈值
        Integer a1 = 1250;
        Integer b1 = 1250;
        System.out.println(String.format("%s == %s, %s", a1, b1, a1==b1));

        // 因为直接使用Integer包装类进行赋值的话，会调用常量池中的对象，是不会产生新对象的。
        // 而用构造方法的话，就会新开辟一个堆空间。
        Integer a2 = new Integer(10);
        Integer b2 = 10;
        System.out.println(String.format("%s == %s, %s", a2, b2, a2==b2));

        Integer a3 = 100;
        //valueOf是从缓存中取值
        Integer b3 = Integer.valueOf(100);
        System.out.println(String.format("%s == %s, %s", a3, b3, a3==b3));

        Integer a4 = 128;
        Integer b4 = new Integer(128);
        //Integer和int进行==比较时，由于会自动拆箱，将Integer转为int
        int c4 = 128;
        System.out.println(String.format("%s == %s, %s", a4, b4, a4==b4));
        System.out.println(String.format("%s == %s, %s", a4, c4, a4==c4));
        System.out.println(String.format("%s == %s, %s", b4, c4, b4==c4));

    }
}
