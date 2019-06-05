package chapter4;

import ctciLibrary.TreeNode;

/**
 * @author yr
 * 有两棵非常大的二叉树T1和T2，判断T2是否为T1的子树，即如果T1存在这么一个节点n，从节点n处把树砍断得到的树和T2完全相同
 */
public class Question4_8 {

    /**
     * 首先在t1中找到和t2根结点相同的节点，然后比较t1子树和t2，检查两棵树是否相同
     * @param t1
     * @param t2
     * @return
     */
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return matchTree(t1, t2);
        }
        return (containsTree(t1.left, t2) || containsTree(t1.right, t2));
    }

    /**
     * 对于t2中的每个节点和t1子树进行比较，如果所有节点和t1子树相同，则返回true，否则返回false
     * @param r1
     * @param r2
     * @return
     */
    public static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        int[] array2 = { 2, 4, 5, 8, 9, 10, 11 };
        int[] array3 = { 1, 2, 3 };
        TreeNode t1 = TreeNode.createTreeFromArray(array1, array1.length);
        TreeNode t2 = TreeNode.createTreeFromArray(array2, array2.length);
        TreeNode t3 = TreeNode.createTreeFromArray(array3, array3.length);
        if (containsTree(t1, t2)) {
            System.out.println("t2 is a subtree of t1");
        } else {
            System.out.println("t2 is a not subtree of t1");
        }
        if (containsTree(t1, t3)) {
            System.out.println("t3 is a subtree of t1");
        } else {
            System.out.println("t3 is a not subtree of t1");
        }
    }

}
