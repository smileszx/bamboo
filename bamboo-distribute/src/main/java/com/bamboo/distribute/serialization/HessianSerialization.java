package com.bamboo.distribute.serialization;

import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/30 15:29
 **/
public class HessianSerialization {

    public static byte[] serialize(Object object) throws IOException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //Hessian对象输出流
        HessianOutput ho = new HessianOutput(os);
        //将对象写入到字节数组输出，进行序列化
        ho.writeObject(object);

        byte[] objByte = os.toByteArray();

        return objByte;
    }
}
