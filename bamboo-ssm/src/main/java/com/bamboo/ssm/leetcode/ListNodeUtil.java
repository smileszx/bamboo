package com.bamboo.ssm.leetcode;

/**
 * @Description
 *
 * 链表相关算法测试通用方法，代码很简陋，仅用于测试
 * @Author victor su
 * @Date 2019/8/9 18:35
 **/
public class ListNodeUtil {
    /**
     * 测试用初始化单链表，但是代码太简陋
     * @param head
     * @param e
     * @return
     */
    public static ListNode add(ListNode head, int e) {
        if (head == null) {
            head = new ListNode(e);
        } else {
            ListNode slow = head;
            //此处目的是通过指针移动的方式获取最后节点
            while (slow.next != null) {
                slow = slow.next;
            }
            //在最后节点的后面添加新的节点
            //LinkedList源码中在全局维护了头结点和尾结点的指针，大神就是大神
            slow.next = new ListNode(e);
        }
        return head;
    }

    /**
     * 自定义遍历打印单链表节点
     * @param head
     * @return
     */
    public static String traverseListNode(ListNode head) {
        StringBuilder str = new StringBuilder();
        while (head != null) {
            str.append(head.val + "->");
            head = head.next;
        }
        str.append("null");
        return str.toString();
    }

}
