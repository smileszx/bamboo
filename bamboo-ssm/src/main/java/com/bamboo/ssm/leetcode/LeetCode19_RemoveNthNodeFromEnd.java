package com.bamboo.ssm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 *
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author victor su
 * @Date 2019/8/10 16:51
 **/
public class LeetCode19_RemoveNthNodeFromEnd {


    public static void main(String[] args) {
        ListNode head = null;
        int[] arr = {1};
        for (int i = 0; i < arr.length; i++) {
            head = ListNodeUtil.add(head, arr[i]);
        }
        System.out.println("初始化ListNode: " + ListNodeUtil.traverseListNode(head));

        int n = 1;

        ListNode dele = removeNthFromEndByDoubleCur(head, n);

        System.out.printf("删除倒数第[%d]节点后：" + ListNodeUtil.traverseListNode(dele), n);
    }


    /**
     * 利用额外的Map空间，空间复杂度O(n),时间复杂度O(n)
     * 将链表节点存入Map中根据Map的size值获取长度，根据指定节点删除
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer, ListNode> map = new HashMap<>();

        int index = 0;

        ListNode cur = head;

        while (cur != null) {
            map.put(index, cur);
            cur = cur.next;
            index ++;
        }

        if(n>map.size())
            return head;

        //获取到倒数第n个节点
        ListNode prev = map.get(map.size() - n);
        //如果倒数第n个节点的下个节点为null，那么待删除的是最后一个节点
        if (prev.next == null) {
            //删除方案是将倒数第2个节点指向null即可
            ListNode preNode = map.get(map.size() - n - 1);
            //极端情况，当前链表只有一个节点，那么相当于清空链表
            if (preNode == null)
               head = null;
            else
            preNode.next = null;
        } else {
            prev.val = prev.next.val;
            prev.next = prev.next.next;
        }
        return head;
    }

    /**
     * 设置虚拟头节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndVMHead(ListNode head, int n) {

        //设置一个虚拟头节点，主要为解决链表只有一个节点，然后还需要删除
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        int index = 0;

        ListNode cur = dummy;

        while (cur != null) {
            map.put(index, cur);
            cur = cur.next;
            index ++;
        }

        //获取到倒数第n个节点
        ListNode prev = map.get(map.size() - n);

        //如果倒数第n个节点的下个节点为null，那么待删除的是最后一个节点
        if (prev.next == null) {
            //删除方案是将倒数第2个节点指向null即可
            ListNode preNode = map.get(map.size() - n - 1);
            preNode.next = null;
        } else {
            prev.val = prev.next.val;
            prev.next = prev.next.next;
        }
        return dummy.next;
    }

    /**
     * 设置虚拟头节点，双指针方式
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndByDoubleCur (ListNode head, int n) {

        ListNode dummy = new ListNode(0);

        dummy.next = head;


        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i= 1; i<=n+1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

}
