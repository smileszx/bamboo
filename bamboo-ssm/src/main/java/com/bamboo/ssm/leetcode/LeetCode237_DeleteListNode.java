package com.bamboo.ssm.leetcode;

/**
 * @Description 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例 1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明:
 * <p>
 * - 链表至少包含两个节点。
 * - 链表中所有节点的值都是唯一的。
 * - 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * - 不要从你的函数中返回任何结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author victor su
 * @Date 2019/8/9 13:32
 **/
public class LeetCode237_DeleteListNode {


    public static void main(String[] args) {
        /**
         * 算法说明：初始化条件
         *  - 链表至少包含两个节点。
         *  - 链表中所有节点的值都是唯一的。
         *  - 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
         *  - 不要从你的函数中返回任何结果。
         */

        ListNode head = null;
        int[] arr = {13, 14, 9, 14, 13, 520};
        for (int i= 0; i<arr.length; i++) {
            head = ListNodeUtil.add(head, arr[i]);
        }
        System.out.println("初始化ListNode: " + ListNodeUtil.traverseListNode(head));
        ListNode target = new ListNode(9);
        deleteListNode(head, target);
        System.out.printf("删除节点[%d]后：" + ListNodeUtil.traverseListNode(head), target.val);
    }


    /**
     * 删除单链表节点
     * @param head
     * @param node
     */
    public static void deleteListNode(ListNode head, ListNode node) {
        ListNode prev = null;
        //遍历单链表，判断待删除节点位置
        for (ListNode x = head; x != null; x = x.next) {
            if (node.val == x.val) {
                if (x.next == null) {
                    prev.next = null;
                } else {
                    x.val = x.next.val;
                    x.next = x.next.next;
                }
            }
            //跳出本次循环后将节点放在临时节点中，作为下次循环的前驱节点
            prev = x;
        }
        //LeetCode算法题也有陷阱,只要求提供解题思路，测试肯定有隐含操作
        //将后继节点变成待删除节点，偷梁换柱，不必管前驱节点，效果是待删除节点消失
//        node.val = node.next.val;
//        node.next = node.next.next;
    }

}
