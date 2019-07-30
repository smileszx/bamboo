package com.bamboo.distribute.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @Description
 * Java中，对象的序列化可以通过实现两种接口来实现，
 *
 * 若实现的是Serializable接口，则所有的序列化将会自动进行，
 *
 * 若实现的是Externalizable接口，则没有任何东西可以自动序列化，
 * 需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。
 * ---------------------
 * 来源：CSDN
 * 原文：https://blog.csdn.net/lisulong1/article/details/52269262
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * @Author victor su
 * @Date 2019/7/30 16:12
 **/
@Data
@Accessors(chain = true)
public class ExternalizableProduct implements Externalizable {
    private long productId;

    private transient String productName;

    private String brand;

    private transient double price;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(productId);
        out.writeObject(productName);
        out.writeObject(brand);
        out.writeObject(price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        productId = (long) in.readObject();
        productName = (String) in.readObject();
        brand = (String) in.readObject();
        price = (double) in.readObject();
    }
}
