package com.bamboo.jdk.clazz;

/**
 * @Description
 * 类变量测试
 * @Author victor su
 * @Date 2019/10/29 16:34
 **/
public class ClazzVariablesTest {
    public static void main(String[] args) {
        ClazzVariables variables = null;
        for (int i=0; i<10; i++) {
            variables = new ClazzVariables();
            System.out.println("id= " + variables.getId() + ", numberOfClazz= " + ClazzVariables.getNumberOfClazz());
        }

        System.out.println(ClazzVariables.getNumberOfClazz());
    }
}
