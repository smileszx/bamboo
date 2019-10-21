package com.bamboo.jdk.leetcode;

/**
 * @Description
 *
 * 876. 链表的中间结点
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author victor su
 * @Date 2019/8/9 19:06
 **/
public class LeetCode876_MiddleNode {

    public static void main(String[] args) {
        ListNode head = null;
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int i= 0; i<arr.length; i++) {
            head = ListNodeUtil.add(head, arr[i]);
        }
        System.out.println("初始化ListNode: " + ListNodeUtil.traverseListNode(head));

        ListNode middleNode = middleNode(head);
        System.out.printf("单链表中间节点-[%d]", middleNode.val);
    }

    public static ListNode middleNode (ListNode node) {
        //快慢指针
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
