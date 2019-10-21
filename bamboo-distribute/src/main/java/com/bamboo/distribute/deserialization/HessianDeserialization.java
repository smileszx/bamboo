package com.bamboo.distribute.deserialization;

import com.caucho.hessian.io.HessianInput;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/30 15:29
 **/
public class HessianDeserialization {

    public static Object deserialize(byte[] byteArray) throws IOException{

        //字节数组输入流
        ByteArrayInputStream is = new ByteArrayInputStream(byteArray);
        //执行反序列化，从流中读取对象

        HessianInput hi = new HessianInput(is);

        Object object = hi.readObject();

        return object;
    }
}
