package com.bamboo.distribute;

import com.bamboo.distribute.deserialization.HessianDeserialization;
import com.bamboo.distribute.deserialization.JavaDeserialization;
import com.bamboo.distribute.po.ExternalizableProduct;
import com.bamboo.distribute.po.Order;
import com.bamboo.distribute.po.Product;
import com.bamboo.distribute.serialization.HessianSerialization;
import com.bamboo.distribute.serialization.JavaSerialization;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * @Description
 * 序列化测试
 * @Author victor su
 * @Date 2019/7/30 15:09
 **/
public class SerializationTest {

    @Test
    public void testSerialization () {

        Product product = new Product();

        product.setProductId(10000).setProductName("Iphone XR").setBrand("Iphone").setPrice(10000.0f);

        try {

            long j_start = System.currentTimeMillis();
            byte[] productArray = JavaSerialization.serialize(product);
            Product pro = (Product)JavaDeserialization.deserialize(productArray);
            long j_end = System.currentTimeMillis();
            System.out.println("Java序列化：" + (j_end - j_start) + "ms");
            System.out.println(productArray);
            System.out.println(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testHessian () {
        Order order = new Order();
        Order.setUserId(123);
        order.setOrderId(20000).setOrderAddress("beijing").setOrderDate(new Date());
        try {

            long h_start = System.currentTimeMillis();
            byte[] orderArray = HessianSerialization.serialize(order);

            order.setUserId(456);

            Order pro = (Order) HessianDeserialization.deserialize(orderArray);
            long h_end = System.currentTimeMillis();
            System.out.println("Hessian序列化：" + (h_end - h_start) + "ms");
            System.out.println(orderArray);
            System.out.println(pro + " " + pro.getUserId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testExternalizable() {
        ExternalizableProduct extern = new ExternalizableProduct();
        extern.setProductId(10000).setProductName("Iphone XR(transient)").setBrand("Iphone").setPrice(10000.0f);
        System.out.println(extern);

        try {
            byte[] externArray = JavaSerialization.serialize(extern);
            ExternalizableProduct externPro = (ExternalizableProduct)JavaDeserialization.deserialize(externArray);
            System.out.println(externPro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
