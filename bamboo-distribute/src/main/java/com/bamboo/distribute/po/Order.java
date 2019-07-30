package com.bamboo.distribute.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 *
 * transient使用小结
 * 1.变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * 2.transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
 *   变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * 3.transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 * @Author victor su
 * @Date 2019/7/30 14:48
 **/
//在类等级中它们同样会遍历类内中的非静态变量，为类中的非静态变量生成访问器代码。
@Data
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 5454596084078427058L;
    private long orderId;

    private String orderAddress;

    private Date orderDate;

    private static int userId;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        Order.userId = userId;
    }
}
