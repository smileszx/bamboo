package com.bamboo.ssm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @Author victor su
 * @Date 2019/8/9 13:32
 **/
public class LeetCode234_CheckPalindromeListNode {

    private static transient ListNode last;


    public static void main(String[] args) {

        ListNode head = null;

        int[] arr = {520, 13, 14, 6, 14, 13, 520};
        for (int i= 0; i<arr.length; i++) {
            head = ListNodeUtil.add(head, arr[i]);
        }
        System.out.println(ListNodeUtil.traverseListNode(head));
        System.out.printf( "回文数检查结果：%s%n", checkListNodeByMap(head));
        System.out.printf( "回文数检查结果：%s%n", isPalindrome(head));

    }

    /**
     * 时间复杂度为O(1),首先想到Map
     */

    public static boolean checkListNodeByMap (ListNode head) {

        //只有一个节点，判断是回文链表
        if (head != null && head.next == null)
            return true;

        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;

        for(ListNode x = head; x!=null; x=x.next) {
            map.put(index, x.val);
            index++;
        }

        for (int i=0; i<map.size();i++) {
            if(!map.get(i).equals(map.get(map.size()-i-1))){
                return false;
            }
        }

        return true;
    }


    public static boolean isPalindrome(ListNode head) {
        //如果链表为空或者只有一个节点，直接返回true
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        //经过分析，单链表长度大于1时，
        // 奇数-> fast指向最后一个非空节点，即fast.next=null
        // 偶数-> fast = null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //为了让空间复杂度为O(1)，翻转后半部分链表
        ListNode iter = slow;

        System.out.println("快慢指针法获取链表中间位置，其中后半部分链表slow：" + ListNodeUtil.traverseListNode(slow));


        ListNode pre = null;
        //反转后半部分链表
        while (iter != null) {
            ListNode temp = iter.next;
            iter.next = pre;
            pre = iter;
            iter = temp;
        }

        System.out.println("后半部分链表反转后pre：" + ListNodeUtil.traverseListNode(pre));


        iter = head;
        ListNode tail = pre;
        //开始对比，看是否有不同的值
        boolean flag = true;
        while (tail != null) {
            if (iter.val != tail.val) {
                flag = false;
                break;
            }
            iter = iter.next;
            tail = tail.next;
        }
        //恢复链表原来的结构，本质上就是再反转一次
        iter = pre;

        pre = null;
        while (iter != null) {
            ListNode temp = iter.next;
            iter.next = pre;
            pre = iter;
            iter = temp;
        }

        System.out.println("后半部分链表再次反转后pre：" + ListNodeUtil.traverseListNode(pre));

        return flag;
    }

}
