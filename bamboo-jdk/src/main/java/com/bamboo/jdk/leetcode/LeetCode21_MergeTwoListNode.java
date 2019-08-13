package com.bamboo.jdk.leetcode;

/**
 * @Description
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author victor su
 * @Date 2019/8/11 19:34
 **/
public class LeetCode21_MergeTwoListNode {

    public static void main(String[] args) {
        ListNode listNode1 = null;
        ListNode listNode2 = null;
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {6, 7, 8};
        for (int i = 0; i < arr1.length; i++) {
            listNode1 = ListNodeUtil.add(listNode1, arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            listNode2 = ListNodeUtil.add(listNode2, arr2[i]);
        }
        System.out.println("初始化ListNode1: " + ListNodeUtil.traverseListNode(listNode1));
        System.out.println("初始化ListNode2: " + ListNodeUtil.traverseListNode(listNode2));


        ListNode merge = mergeTwoLists(listNode1,listNode2);

        System.out.printf("两个有序链表合并后 ：" + ListNodeUtil.traverseListNode(merge));
    }


    /**
     * 设置虚拟头节点，移动指针归并添加节点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建虚拟头节点
        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        if(l1 == null && l2==null)
            return null;
        while (l1 != null && l2 != null){

            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }
        if(l2 == null){
            cur.next = l1;
        }

        return dummy.next;
    }

}
