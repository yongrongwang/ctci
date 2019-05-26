package chapter4;

import ctciLibrary.TreeNode;

/**
 * @author yr
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。给定指向树根结点的指针TreeNode* root
 * ，请返回一个bool，代表这棵树是否平衡。
 */
public class Question4_1 {
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /**
     * 直接递归访问整颗树，如果每个节点左右子树高度都相等则平衡
     * @param root
     * @return
     */
    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else { // 递归遍历
            return isBalance(root.left) && isBalance(root.right);
        }
    }

    /**
     * 递归检查左子树、右子树和当前结点是否平衡，如果不平衡则直接返回-1，如果平衡返回树的高度
     * @param root
     * @return
     */
    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 检查左子树是否平衡
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        // 检查右子树是否平衡
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 检查当前结点是否平衡
        int heighDiff = leftHeight - rightHeight;
        if (Math.abs(heighDiff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced2(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 10;
        int[] arr = TreeNode.sortedArray(length);
        TreeNode root = TreeNode.createMinimalBST(arr, 0, arr.length - 1);
        System.out.println("root: " + root.val);
        System.out.println("Is balanced? " + isBalance(root) + " " + isBalanced2(root));

        TreeNode.insertInOrder(root, 9);
        System.out.println("root: " + root.val);
        System.out.println("Is balanced? " + isBalance(root) + " " + isBalanced2(root));
    }

}
