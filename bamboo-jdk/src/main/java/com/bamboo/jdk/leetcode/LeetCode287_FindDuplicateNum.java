package com.bamboo.jdk.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，
 * 其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author victor su
 * @Date 2019/8/11 20:53
 **/
public class LeetCode287_FindDuplicateNum {

    public static void main(String [] args) {
        int [] nums = {1,3,4,2,2,2};
        System.out.println(findDuplicateDoubleCur(nums));
    }
//    时间复杂度太高
//    public static int findDuplicate(int[] nums) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i=0; i< nums.length; i++) {
//            map.put(nums[i], 1);
//
//            for(int j = i+1; j<nums.length; j++){
//                if(map.containsKey(nums[j])) {
//                    map.put(nums[j], map.get(nums[j]) + 1);
//                }
//            }
//            if (map.get(nums[i]) > 1) {
//                return nums[i];
//            } else {
//                map.remove(nums[i]);
//            }
//        }
//
//        return -1;
//    }


    public static int findDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

    /**
     *  算法题目中限定的条件
     *  给定一个包含 n + 1 个整数的数组 nums，
     *  其数字都在 1 到 n 之间（包括 1 和 n），
     *  可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * @param nums
     * @return
     */
    public static int findDuplicateDoubleCur(int[] nums) {
        // Find the intersection point of the two runners.
//        int tortoise = nums[0];
//        int hare = nums[0];
//        do {
//            tortoise = nums[tortoise];
//            hare = nums[nums[hare]];
//        } while (tortoise != hare);
//
//        // Find the "entrance" to the cycle.
//        int ptr1 = nums[0];
//        int ptr2 = tortoise;
//        while (ptr1 != ptr2) {
//            ptr1 = nums[ptr1];
//            ptr2 = nums[ptr2];
//        }
//
//        return ptr1;

        //Floyd判圈算法
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
