package com.bamboo.distribute.deserialization;

import java.io.*;

/**
 * @Description
 * Java 反序列化
 * @Author victor su
 * @Date 2019/7/30 15:04
 **/
public class JavaDeserialization {

    public static Object deserialize(byte[] byteArray) throws IOException, ClassNotFoundException {

        //字节数组输入流
        ByteArrayInputStream is = new ByteArrayInputStream(byteArray);
        //执行反序列化，从流中读取对象
        ObjectInputStream in = new ObjectInputStream(is);

        Object object = in.readObject();

        return object;
    }
}
