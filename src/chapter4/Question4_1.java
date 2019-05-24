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

    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalance(root.left) && isBalance(root.right);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        TreeNode root = TreeNode.createMinimalBST(arr, 0, arr.length - 1);
        System.out.println("root: " + root.data);
        System.out.println("Is balanced? " + isBalance(root));
    }

}
