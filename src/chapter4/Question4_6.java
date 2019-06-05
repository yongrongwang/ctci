package chapter4;

import ctciLibrary.TreeNode;

/**
 * @author yr
 * 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点
 * 的后继结点的值。保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
 */
public class Question4_6 {

    static TreeNode pre = new TreeNode(-1);

    /**
     * 采用递归方法中序遍历，使用一个指针pre指向前一个节点，如果前一个节点的数值等于p，则返回当前节点的数值，否则pre指向root，继续递归遍历
     * @param root 根结点
     * @param p 结点的值
     * @return 后继结点的值
     */
    public static int findSucc(TreeNode root, int p) {
        if (root == null) {
            return -1;
        }
        // 寻找最左边的节点
        int left = findSucc(root.left, p);
        // 找到节点，则直接返回值
        if (left != -1) {
            return left;
        }
        // 如果前一个节点是要找的节点，则返回当前节点的数值
        if (pre.val == p) {
            return root.val;
        }
        // 如果前一个节点不是要找的节点，则pre指向root
        pre = root;
        return findSucc(root.right, p);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = TreeNode.sortedArray(20);
        TreeNode root = TreeNode.createMinimalBST(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            int succ = findSucc(root, i);
            System.out.println(i + "->" + (succ == -1 ? null : succ));
        }
    }

}
