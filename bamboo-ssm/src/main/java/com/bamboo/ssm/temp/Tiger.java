package com.bamboo.ssm.temp;

import java.util.List;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 17:14
 **/
public class Tiger implements Animal {

    private String place;

    private List<String> food;

    public Tiger(String place, List<String> food) {
        this.place = place;
        this.food = food;
    }

    @Override
    public void introduce() {
        System.out.println("I am a tiger, I come from " + place);
        System.out.println("I like eat : ");
        for (String s : food) {
            System.out.println(s);
        }
    }
}
