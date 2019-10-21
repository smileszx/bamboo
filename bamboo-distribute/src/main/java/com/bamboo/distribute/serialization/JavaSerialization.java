package com.bamboo.distribute.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Description
 * Java 序列化
 * https://github.com/eishay/jvm-serializers/wiki 序列化效率测试
 * @Author victor su
 * @Date 2019/7/30 14:59
 **/
public class JavaSerialization {

    public static byte[] serialize(Object object) throws IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //对象输出流
        ObjectOutputStream out = new ObjectOutputStream(os);
        //将对象写入到字节数组输出，进行序列化
        out.writeObject(object);

        byte[] objByte = os.toByteArray();

        return objByte;
    }
}
