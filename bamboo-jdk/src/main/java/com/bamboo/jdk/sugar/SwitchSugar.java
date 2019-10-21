package com.bamboo.jdk.sugar;

/**
 * 语法糖：switch 支持 String和枚举值
 */
public class SwitchSugar {

    public static void main(String[] args) {
        String str = "world";
        switchString(str);

        SwitchEnum switchEnum = SwitchEnum.SPRING;
        switchEnum(switchEnum);
    }


    public static void switchEnum (SwitchEnum switchEnum) {
        switch (switchEnum) {
            case SPRING:
                System.out.println(switchEnum.getName() + "- 清明时节雨纷纷");
                break;
            case SUMMER:
                System.out.println(switchEnum.getName() + "-小荷才露尖尖角");
                break;
            case FALL:
                System.out.println(switchEnum.getName() + "- 我言秋日胜春朝");
                break;
            case WINTER:
                System.out.println(switchEnum.getName() + "- 瑞雪兆丰年");
                break;
            default:
                break;
        }
    }

    /**
     * JDK1.7支持String类型，底层通过 equals 和 hashCode判定
     * @param str
     */
    public static void switchString (String str) {
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }
    }
}