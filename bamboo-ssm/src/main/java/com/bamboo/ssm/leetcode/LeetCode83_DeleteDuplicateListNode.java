package com.bamboo.ssm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 博客： https://www.jianshu.com/p/666cd750c378
 * 文章给出多种删除重复元素的场景，可以参考
 *
 *
 *
 * @Author victor su
 * @Date 2019/8/9 19:16
 **/
public class LeetCode83_DeleteDuplicateListNode {


    public static void main(String[] args) {
        ListNode head = null;
        int[] arr = {1, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            head = ListNodeUtil.add(head, arr[i]);
        }
        System.out.println("初始化ListNode: " + ListNodeUtil.traverseListNode(head));

        ListNode set = deleteDupNode3(head);

        System.out.printf("删除重复节点后：" + ListNodeUtil.traverseListNode(set));
    }

    /**
     * 算法描述中前置条件是有序链表，意思是重复元素相邻
     * @param head
     * @return
     */
    public static ListNode deleteDuplicateOrderListNode(ListNode head) {
        //指针
        ListNode cur = head;
        //指针所指节点不为空，指针所指节点的下个节点也不为空
        while (cur != null && cur.next != null) {
            //如果两个节点值相同，执行删除操作
            if (cur.val == cur.next.val) {
                //创建临时节点存储当前指针的下一个节点
                ListNode node = cur.next;
                //移动当前指针的下个节点指向，指向下下个节点
                cur.next = node.next;

                node.next = null;//清除野指针，因为node只作为临时变量
            } else {
                //如果节点不重复，指针向后移动一步
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDupNode3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;

        while (cur != null) {
//          map.put(cur.val,map.getOrDefault(cur.val,0)+1);// 累计+1
            map.merge(cur.val, 1, Integer::sum); //更简洁的写法，取出 map 中对应于 cur.val的值count，没有设为0; 再和 1相加存入
            cur = cur.next;
        }

        ListNode prev = null;
        cur = head.next;
        while (cur != null) {
            if (map.get(cur.val) > 1) {
                if (prev != null) {
                    // 当前节点需要删除
                    prev.next = cur.next;
                }
                map.put(cur.val, map.get(cur.val) - 1);
            } else {
                // 当前节点保留
                if (prev == null) {
                    head = cur;
                }
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    /**
     * 链表元素无序，但是存在重复，删除重复元素
     * @param head
     *
    **/
    public static ListNode deleteDuplicateListNode(ListNode head) {

        if(head == null || head.next == null)
            return head;
        Map<Integer, Integer> map = new HashMap<>();

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null && cur.next != null) {
            if (map.containsKey(cur.val)) {
                if(cur.next.next == null) {
                    //进到这个逻辑，指针指向倒数第2个元素
                    //预判一下最后两个节点是否相等
                    if(cur.val == cur.next.val) {
                        prev.next = null;
                    }
                } else {
                    //删除当前节点，当前节点变成下个节点，那么指针当前所指节点是否重复呢？
                    //方案： 放在临时节点中
                    cur.val = cur.next.val;
                    cur.next = cur.next.next;
                }

            } else {
                map.put(cur.val, cur.val);
                cur = cur.next;
            }
            //记录前驱节点，当最后一个节点需要删除时，将前驱节点指向null
            prev = cur;
        }

        //此时cur指向最后一个节点，此时判断该节点是否重复
        if (map.containsKey(cur.val) && cur.next == null) {
            prev.next = null;
        }

        return head;
    }
}
