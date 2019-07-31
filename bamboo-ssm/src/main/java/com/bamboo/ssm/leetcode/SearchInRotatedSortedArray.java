package com.bamboo.ssm.leetcode;

/**
 * @Description
 * 搜索旋转排序数组 II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * @Author victor su
 * @Date 2019/7/31 10:13
 **/
public class SearchInRotatedSortedArray {


    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 1, 1, 1, 2};
        int taget = 5;

        boolean result = searchIfExists(nums, taget);
        System.out.println(result);

        int index = searchIfExistsIndex(nums, taget);
        System.out.println("index: " + index + ", target: " + nums[index]);
    }

    /**
     * 判断目标数字是否在数组内
     * @param nums 升序数组，发生旋转
     * @param target 目标数字
     * @return
     */
    public static boolean searchIfExists(int[] nums, int target) {

        if (nums == null || nums.length == 0)
        return false;

        int left=0, right=nums.length-1;


        while (left <= right){

            int mid = left + (right - left) / 2;

            if (nums[mid] == target || nums[left] == target || nums[right] == target)
                return true;
            //中间数字大于最左侧数字，那说明中间数字在前段
            if(nums[mid] > nums[left]) {

                //目标数字大于中间数字，判断目标数字在前段，left = mid + 1
                if (target > nums[mid]) {
                   left = mid +1;

                } else { //目标数字小于中间数字，无法判断目标数字在前段还是后端，需要分情况判断

                    if(target > nums[left]) {//目标数字比最左侧数字大，则判断在前段
                        right = mid - 1;
                    } else {//目标数字比最左侧数字小，则判断在后段

                        left = mid + 1;
                    }
                }
            } else if (nums[mid] < nums[left]) {//中间数字比最左侧数字小，则判断中间数字在后段

                //目标数字比中间数字大，则无法判断目标数字在前段后者后段
                if(target > nums[mid]) {

                    //目标数字比最左侧数字大，那么一定在前段
                    if (target > nums[left]) {
                        right = mid - 1;
                    } else {
                        //目标数字比最左侧数字小，一定在后段
                        left = mid + 1;
                    }
                } else {
                    //目标数字比中间数字小，那么一定在后段
                    right = mid - 1;
                }

            } else { //中间数字与左侧数字相等，特殊情况，无法讨论只能按部就班的比对
                left ++; //或者 right--
            }
        }
        return false;
    }

    public static int searchIfExistsIndex(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return -1;

        int left=0, right=nums.length-1;


        while (left <= right){

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;

            //中间数字大于最左侧数字，那说明中间数字在前段
            if(nums[mid] > nums[left]) {

                //目标数字大于中间数字，判断目标数字在前段，left = mid + 1
                if (target > nums[mid]) {
                    left = mid +1;

                } else { //目标数字小于中间数字，无法判断目标数字在前段还是后端，需要分情况判断

                    if(target > nums[left]) {//目标数字比最左侧数字大，则判断在前段
                        right = mid - 1;
                    } else {//目标数字比最左侧数字小，则判断在后段

                        left = mid + 1;
                    }
                }
            } else if (nums[mid] < nums[left]) {//中间数字比最左侧数字小，则判断中间数字在后段

                //目标数字比中间数字大，则无法判断目标数字在前段后者后段
                if(target > nums[mid]) {

                    //目标数字比最左侧数字大，那么一定在前段
                    if (target > nums[left]) {
                        right = mid - 1;
                    } else {
                        //目标数字比最左侧数字小，一定在后段
                        left = mid + 1;
                    }
                } else {
                    //目标数字比中间数字小，那么一定在后段
                    right = mid - 1;
                }

            } else { //中间数字与左侧数字相等，特殊情况，无法讨论只能按部就班的比对
                left ++; //或者 right--
            }
        }
        return -1;
    }

    /**
     * 無重複元素的有序數組，返回待查元素索引
     * @param nums
     * @param target
     * @return
     */
    public static int searchIfExistsIndexNoRepeatable(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return -1;

        int left=0, right=nums.length-1;

        while (left <= right){

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;

            //目標元素大於中間元素，無法判斷在前段還是後段，分情況討論
            if (target > nums[mid]) {
                //中間元素大於最左側元素，則目標元素在前段
                if (nums[mid] > nums[left]) {
                        left = mid + 1;
                } else {//中間元素小於最左側元素，則中間元素在後段
                    //目標元素大於最左側元素，目標元素在前段
                    if (target > nums[left])
                        right = mid - 1;
                    //目標元素小於於最左側元素，目標元素在後段
                    else
                        left = mid + 1;
                }

            } else {//目標元素小於於中間元素，無法判斷在前段還是後段，分情況討論
                if (nums[mid] > nums[left]) {
                    if (target < nums[left])
                        left = mid + 1;
                    else
                        right = mid - 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
