package com.bamboo.jdk.parameter;

/**
 *
 * 关于值传递和引用传递
 *
 * 梳理一下：
 * - 基本类型
 * 基本类型，值直接保存在变量中
 * - 引用类型
 * 引用类型，变量中保存的是实际对象的地址，实际对象中保存具体内容。
 *
 * 赋值问题：
 * - 基本类型
 * 赋值运算符会直接改变变量值，原来的值被覆盖掉。
 * - 引用类型
 * 赋值运算符会改变引用所保存的地址，原来的地址被覆盖掉，但是原来地址所指向的对象不会被改变（重要）
 *
 * 参数传递：
 * - 基本类型
 * Primitive arguments, such as an int or a double, are passed into methods by value.
 * This means that any changes to the values of the parameters exist only within the scope of the method.
 * When the method returns, the parameters are gone and any changes to them are lost.
 * 大致意思就是基本类型的参数，传入方法的是值本身，对于该值的修改仅在方法内部，当方法返回后参数发生的任何改变全丢失，因此值不变。
 * void foo(int value) {
 *     value = 100;
 * }
 * foo(num); // num 没有被改变
 *
 * - 引用类型
 *
 *   - 没有提供改变自身方法的引用类型
 *   void foo(String text) {
 *       text = "windows";
 *   }
 *   foo(str); // str 也没有被改变
 *
 *   - 提供了改变自身方法的引用类型
 *   StringBuilder sb = new StringBuilder("iphone");
 *   void foo(StringBuilder builder) {
 *       builder.append("4");
 *   }
 *   foo(sb); // sb 被改变了，变成了"iphone4"。
 *
 *   - 提供了改变自身方法的引用类型，但是不使用，而是使用赋值运算符。
 *   StringBuilder sb = new StringBuilder("iphone");
 *   void foo(StringBuilder builder) {
 *       //此时builder指向了“ipad”对象的地址
 *       builder = new StringBuilder("ipad");
 *   }
 *   foo(sb); // sb 没有被改变，还是 "iphone"
 *
 */
public class PassPrimitiveByValue {

    public static void main(String[] args) {
           
        int x = 3;
           
        // invoke passMethod() with 
        // x as argument
        passMethod(x);
           
        // print x to see if its 
        // value has changed
        System.out.println("After invoking passMethod, x = " + x);


        Circle myCircle = new Circle(1, 1);

        moveCircle(myCircle, 23, 56);

        System.out.println("myCircle: x= " + myCircle.getX() + ", y= " + myCircle.getY());

        Circle yourCircle = new Circle(1, 1);

        moveCircleNoChange(yourCircle, 6, 6);

        System.out.println("yourCircle: x= " + yourCircle.getX() + ", y= " + yourCircle.getY());


    }
        
    // change parameter in passMethod()
    public static void passMethod(int p) {
        p = 10;
    }

    /**
     * final修饰的基本类型形参，不允许被修改，否则编译错误
     * @param key
     */
    public static void passMethodWithFinalVariable (final int key) {
       // key = 10; //无法编译通过
    }

    public static void moveCircle(Circle circle, int deltaX, int deltaY) {
        // code to move origin of circle to x+deltaX, y+deltaY
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        // code to assign a new reference to circle
        circle = new Circle(0, 0);

        System.out.println("circle: x= " + circle.getX() + ", y= " + circle.getY());
    }

    /**
     * final修饰的引用类型参数，不能修改引用，但可以修改引用对象内部的属性；
     * @param circle
     * @param deltaX
     * @param deltaY
     */
    public static void moveCircleWithFinal(final Circle circle, int deltaX, int deltaY) {
        // code to move origin of circle to x+deltaX, y+deltaY
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        // code to assign a new reference to circle
        // circle = new Circle(0, 0); can not assign

        System.out.println("circle: x= " + circle.getX() + ", y= " + circle.getY());
    }

    public static void moveCircleNoChange(Circle circle, int deltaX, int deltaY) {

        // code to assign a new reference to circle
        circle = new Circle(3, 3);

        System.out.println("circle: x= " + circle.getX() + ", y= " + circle.getY());
    }
}