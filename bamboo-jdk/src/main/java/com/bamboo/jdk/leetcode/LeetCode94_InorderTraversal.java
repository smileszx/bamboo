package com.bamboo.jdk.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 * 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。若二叉树为空则结束返回，否则：
 * （1）中序遍历左子树
 * （2）访问根结点
 * （3）中序遍历右子树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author victor su
 * @Date 2019/8/15 10:35
 **/
public class LeetCode94_InorderTraversal {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> orderList = new ArrayList<>();
        if(root == null)
            return orderList;
        recursive(root, orderList);
        return orderList;
    }

    public static void recursive(TreeNode root, List<Integer> res){
        if(root != null){
            if (root.left != null) {
                recursive(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                recursive(root.right, res);
            }
        }
    }
}
