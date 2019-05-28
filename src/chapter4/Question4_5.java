package chapter4;

import ctciLibrary.TreeNode;

/**
 * @author yr
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
public class Question4_5 {
    public static int last = Integer.MIN_VALUE;

    /**
     * 使用中序遍历的方法，用一个变量保存上一个结点的值，如果所有结点都满足当前结点的值大于上一个结点的值，则返回true
     * @param root
     * @return
     */
    public static boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 检查左子树
        if (!checkBST(root.left)) {
            return false;
        }
        // 检查当前结点
        if (root.val < last) {
            return false;
        }
        last = root.val;
        // 检查右子树
        if (!checkBST(root.right)) {
            return false;
        }
        // 全部检查完毕
        return true;
    }

    /**
     * 自上而下递归遍历整棵树的过程中传递最小和最大值，用逐渐缩小的区间对所有结点进行检查
     * @param root
     * @return
     */
    public static boolean checkBST2(TreeNode root) {
        return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 首先判断该节点是否落在[min,max]之间，如果不是，直接返回false，然后递归遍历左右子树，进入左子树则更新max，进入右子树则更新min，只要
     * 有一个结点没有落在[min,max]之间就返回false
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static boolean checkBST2(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val >= max) {
            return false;
        }
        return checkBST2(root.left, min, root.val) && checkBST2(root.right, root.val, max);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 15;
        int[] array = TreeNode.sortedArray(length);
        TreeNode tree = TreeNode.createMinimalBST(array, 0, length - 1);
        System.out.println("Is BST? " + checkBST(tree) + " " + checkBST2(tree));
        TreeNode.insertInOrder(tree, 9);
        System.out.println("Is BST? " + checkBST(tree) + " " + checkBST2(tree));
    }

}
