package com.bamboo.jdk.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/17 23:23
 **/
public class StreamTest {

    public static void main(String[] args) {

        List<Artist> list = new ArrayList<>();
        Artist artist = null;
        for(int i=0; i< 10; i++) {
            artist = new Artist();
            artist.setComeFrom("Beijing");
            list.add(artist);
        }
        for(int i=0; i< 3; i++) {
            artist = new Artist();
            artist.setComeFrom("London");
            list.add(artist);
        }

//        testForCycle(list);
//        testLambdaStream(list);
        testStream(list);
    }


    public static void testStream (List<Artist> list) {
        list.stream().filter(artist -> {
                    System.out.println(artist.getComeFrom());
                    return artist.getComeFrom().equals("London");
                }).count();
    }
    /**
     * Stream过滤并统计
     * @param list
     */
    public static void testLambdaStream (List<Artist> list) {
        long count = list.stream()
                .filter(artist -> artist.getComeFrom().equals("London"))
                .count();
        System.out.println(count);
    }

    /**
     * for循环遍历
     * @param list
     */
    public static void testForCycle (List<Artist> list) {

        int count = 0;
        Iterator<Artist> iterator = list.iterator();
        while(iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.getComeFrom().equals("London")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
