package com.bamboo.jdk.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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

        testReduce ();
    }

    public static void testReduce () {
        int count = Stream.of(10, 20, 30)
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer acc, Integer element) {
                        return acc + element;
                    }
                });

        System.out.println(count);

       // 0, (acc, element) -> acc + element
    }

    /**
     * flatMap 对应Function函数式接口
     */
    public static void testFlatMap() {
        List<Integer> together = Stream.of(Arrays.asList(12, 2), Arrays.asList(13, 4))
                .flatMap(numbers -> numbers.stream())
                .sorted()
                .collect(toList());
        System.out.println(together);
    }

    /**
     * map 对应Function函数式接口
     */
    public static void testMap () {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.toUpperCase();
                    }
                })
                .collect(toList());
        System.out.println(collected);
        //string -> string.toUpperCase()
    }

    public static void testCollect() {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(toList());
        boolean result = Arrays.asList("a", "b", "c").equals(collected);
        System.out.println(result);
    }

    public static void testStream (List<Artist> list) {
        list.stream().filter(artist -> {
                    System.out.println(artist.getComeFrom());
                    return artist.getComeFrom().equals("London");
                }).count();
    }
    /**
     * Stream过滤并统计
     * filter 对应Predicate函数式接口
     * @param list
     */
    public static void testLambdaStream (List<Artist> list) {
        long count = list.stream()
                .filter(new Predicate<Artist>() {
                    @Override
                    public boolean test(Artist artist) {
                        return artist.getComeFrom().equals("London");
                    }
                })
                .count();
        System.out.println(count);
        //artist -> artist.getComeFrom().equals("London")
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
