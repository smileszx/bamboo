package com.bamboo.ssm.leetcode;

import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/reverse-linked-list/
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author victor su
 * @Date 2019/8/8 21:44
 **/
public class LeetCode206_ReverseListNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode reverse = reverseListNodeByRecursion(head);


        StringBuilder str = new StringBuilder();
        while (reverse != null) {
            str.append(reverse.val + "->");
            reverse = reverse.next;
        }
        System.out.println(str.toString());
    }


    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 对一个节点指针翻转时，需要知道三个节点
     * - 待翻转的节点
     * - 待翻转节点的前驱节点 prev
     * - 待翻转节点的后续节点 next
     * @param head
     * @return
     */
    public static ListNode reverseListNode (ListNode head) {

        if (head == null || head.next == null)
            return head;

        //前驱和后继是针对待反转节点反转之前而言
        ListNode preNode = null;
        ListNode nextNode = null;

        while (head != null) {
            //当前节点后继节点
            nextNode = head.next;
            //当前节点后继节点，修改为原来的前驱节点
            head.next = preNode;
            //前驱节点向后移动一步
            preNode = head;
            //当前节点向后移动一步
            head = nextNode;
        }

        return preNode;
    }


    /**
     * 递归方式实现
     * @param head
     * @return
     */
    public static ListNode reverseListNodeByRecursion (ListNode head) {

        if (head == null || head.next == null)
        return head;

        ListNode newHead = reverseListNodeByRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
