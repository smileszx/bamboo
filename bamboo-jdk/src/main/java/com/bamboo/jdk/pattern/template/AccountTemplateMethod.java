package com.bamboo.jdk.pattern.template;

/**
 * @Description
 * 模板方法模式
 * @Author victor su
 * @Date 2019/8/30 12:06
 **/
public abstract class AccountTemplateMethod {

    public boolean validate(String user, String password) {
        if(user.equals("admin") && password.equals("admin")) {
            return true;
        }

        return false;
    }

    public abstract void calculate ();

    public void display() {
        System.out.println("============显示信息==============");
    }


    public void handle (String usr, String pw) {
        if(!validate(usr,pw)) {
            System.out.println("登陆失败");
            return;
        }
        calculate();
        display();
    }

}
