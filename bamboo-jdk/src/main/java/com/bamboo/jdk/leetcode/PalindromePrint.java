package com.bamboo.jdk.leetcode;

/**
 * @Description
 *
 * VIPKID 架构总监随机出的简单算法题
 * 参数为整型n
 * 打印数据格式
 * 1
 * 121
 * 12321
 * 1234321
 * ...
 * @Author victor su
 * @Date 2019/8/11 23:42
 **/
public class PalindromePrint {

    public static void main(String[] args) {
        int n = 9;
        palindromePrint(n);
    }


    public static void palindromePrint(int n) {

        for( int i = 1; i <= n; i++){
            for( int j = 1; j <=n-i ; j++){
                System.out.print(" ");
            }
            int temp = 0;
            for( int k = 1; k <= 2*i-1 ; k++){
                if(k <= (2*i-1)/2 + 1){
                    temp = k;
                    System.out.print(k);
                } else {
                    System.out.print(--temp);
                }

            }
            //换一行
            System.out.println();
        }

    }

}
