package com.bamboo.jdk.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description
 * 桶排序
 * https://yq.aliyun.com/articles/642727?spm=a2c4e.11153940.0.0.6c5c6ce8McQ7ZZ
 * @Author victor su
 * @Date 2019/8/10 22:12
 **/
public class BucketSort {

    public static void main(String[] args) {
        int [] nums = {3, 5, 6, 7, 2, 4, 2, 123, 444, 667 ,734};
        bucketSort(nums);
    }


    public static void bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        System.out.println(bucketArr.toString());
    }

}
