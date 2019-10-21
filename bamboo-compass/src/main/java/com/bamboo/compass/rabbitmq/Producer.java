package com.bamboo.compass.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/12 20:37
 **/
public class Producer {

    public static void main(String[] args) throws Exception{


        //1. 创建ConnectionFactory
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.101");
        factory.setPort(5672);
        factory.setVirtualHost("/");

        //2. 创建连接
        Connection connection = factory.newConnection();

        //3. 创建信道

        Channel channel = connection.createChannel();

        channel.exchangeDeclare("cc", BuiltinExchangeType.DIRECT,true);

        //4. 发布消息
        String msg = "bamboo";
        for(int i = 0; i<100; i++) {
            channel.basicPublish("cc", "hello", null, msg.getBytes());
            System.out.println(i);
            Thread.sleep(1000);
        }

        //5. 关闭资源
//        channel.close();
//        connection.close();
    }
}
