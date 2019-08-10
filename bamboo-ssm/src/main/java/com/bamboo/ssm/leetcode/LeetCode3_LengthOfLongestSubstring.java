package com.bamboo.ssm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 *
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author victor su
 * @Date 2019/8/10 10:32
 **/
public class LeetCode3_LengthOfLongestSubstring {

    public static void main(String[] args) {
//        String s = "bbbbb";
//        String s = "abcabcbb";
//        String s = "pwwkew";
//        String s = " ";
        String s= "tmmzuxt";
//

        int length = lengthOfLongestSubstring(s);

        System.out.printf("字符串[%s], 无重复字符的最长子串length: %d %n", s, length);
    }


    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //如果map包含当前j所指向的字符，那么越过当前字符，将i指向当前字符的下一个字符
                //妙就妙在如果是遍历过的元素，其索引与i值比较：如果比i小，i值不变；如果比i值大，i值变为索引值加1
                //这个工作可以简化到map
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }


    /**
     * 滑动窗口是数组/字符串问题中常用的抽象概念。
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
     * 即 [i, j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
     * 例如，我们将 [i, j)向右滑动 1个元素，则它将变为 [i+1, j+1)（左闭，右开）。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringBySet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
