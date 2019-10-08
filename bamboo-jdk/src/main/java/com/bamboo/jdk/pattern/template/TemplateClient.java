package com.bamboo.jdk.pattern.template;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/30 12:18
 **/
public class TemplateClient {

    public static void main(String[] args) {
        AccountTemplateMethod saving, current;
        saving = new SavingAccount();
        saving.handle("admin", "admin");
        current = new CurrentAccount();
        current.handle("admin", "admin");
    }
}
