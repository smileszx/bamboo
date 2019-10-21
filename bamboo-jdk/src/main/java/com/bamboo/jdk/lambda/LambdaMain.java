package com.bamboo.jdk.lambda;

import com.bamboo.jdk.pojo.Device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Description Lambda表达式目前为止大部分开发者无法熟练运用，甚至不了解。
 * @Author victor su
 * @Date 2019/8/6 9:37
 **/
public class LambdaMain {


    //    @FunctionalInterface
    public static void main(String[] args) {
//        new Thread(()->System.out.println(Thread.currentThread().getName())).start();
/**
        //对比函数式接口编程方式
        Runnable runnable = ()-> System.out.println("hello runnable");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("old hello runnable");
            }
        };
**/

/**
        //测试Function
        Function<Device, Integer> function = device -> device.getDeviceId();
        Device d = new Device(1, "AGV");
        Integer deviceId = function.apply(d);
        System.out.println(deviceId);

**/
/**
 * //测试Predicate
        List<Device> devices = Arrays.asList(
                new Device(1, "sort_agv"),
                new Device(2, "wolf_agv"),
                new Device(3, "shuttle")
        );


        List<Device> shuttle = filter(devices, (device)->device.getDeviceType().equals("shuttle"));
        System.out.println(shuttle);

        List<Device> resultById = filterById(devices, id -> (id == 2));
        System.out.println(resultById);

        List<Device> bi = filterBiPredicate(devices, (id, type) ->
            id==1 && type.equals("sort_agv")
        );
        System.out.println(bi);
 **/




    }

    public static List<Device> filter(List<Device> source, Predicate<Device> predicate) {
        List<Device> result = new ArrayList<>();
        for (Device device : source) {
            if(predicate.test(device)){
                result.add(device);
            }
        }
        return result;
    }

    public static List<Device> filterById(List<Device> source, Predicate<Integer> predicate) {
        List<Device> result = new ArrayList<>();
        for (Device device : source) {
            if(predicate.test(device.getDeviceId())){
                result.add(device);
            }
        }
        return result;
    }

    public static List<Device> filterBiPredicate (List<Device> source, BiPredicate<Integer, String> predicate) {
        List<Device> result = new ArrayList<>();
        for (Device device : source) {
            if(predicate.test(device.getDeviceId(), device.getDeviceType())){
                result.add(device);
            }
        }
        return result;
    }
}
