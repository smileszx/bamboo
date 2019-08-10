package com.bamboo.ssm.leetcode;

/**
 * 定义单链表节点
 */
public class ListNode {
    int val;
    //单链表特点，每个节点中只包含指向后继节点的引用
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}