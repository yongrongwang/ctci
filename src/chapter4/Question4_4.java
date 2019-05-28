package chapter4;

import ctciLibrary.ListNode;
import ctciLibrary.TreeNode;

/**
 * @author yr
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个
 * 链表ListNode，代表该深度上所有结点的值，请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
public class Question4_4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 40;
        int[] arr = TreeNode.sortedArray(length);
        TreeNode root = TreeNode.createTreeFromArray(arr, arr.length);
        int max = (int) (Math.log(arr.length) / Math.log(2)) + 1;
        for (int dep = 1; dep <= max; dep++) {
            System.out.print("dep = " + dep + ", ");
            TreeLevel level = new TreeLevel();
            ListNode head = level.getTreeLevel(root, dep);
            System.out.println("tree level" + ": " + head.printForward());
        }
    }

}

class TreeLevel {
    ListNode head = null;
    ListNode p = head;

    /**
     * 使用深度优先的遍历方式，每次向下遍历一层就对dep减去一，当dep为一的时候表明到了指定深度的层次，然后构建链表
     * @param root
     * @param dep
     * @return
     */
    public ListNode getTreeLevel(TreeNode root, int dep) {
        if (root == null || dep <= 0) {
            return null;
        }
        if (dep == 1) {
            if (head == null) {
                head = new ListNode(root.val);
                p = head;
            } else {
                p.next = new ListNode(root.val);
                p = p.next;
            }
        } else {
            getTreeLevel(root.left, dep - 1);
            getTreeLevel(root.right, dep - 1);
        }
        return head;
    }

}