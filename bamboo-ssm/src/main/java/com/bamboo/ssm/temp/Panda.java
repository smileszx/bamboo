package com.bamboo.ssm.temp;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/7/16 0:06
 **/
public class Panda {

    private Bamboo bamboo;

    private Rabbit rabbit;

    public Panda (Bamboo bamboo) {
        this.bamboo = bamboo;
    }

    public void eat () {
        System.out.println("I am a panda, I eat " + bamboo.showName());
    }

    public void friend() {
        System.out.println("I have a good friend: ");
        rabbit.introduce();
    }

    public void setRabbit(Rabbit rabbit) {
        this.rabbit = rabbit;
    }

    public Rabbit getRabbit() {
        return rabbit;
    }
}
