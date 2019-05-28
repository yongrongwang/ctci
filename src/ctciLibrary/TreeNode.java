package ctciLibrary;

import java.util.LinkedList;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public static int[] sortedArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalBST(arr, start, mid - 1);
        node.right = createMinimalBST(arr, mid + 1, end);
        return node;
    }

    /**
     * 使用数组来从上到下从左到右创建一棵树
     * @param arr
     * @return
     */
    public static TreeNode createTreeFromArray(int[] arr, int length) {
        if (arr == null || length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        for (int i = 1; i < length;) {
            TreeNode node = queue.element();
            if (node.left == null) {
                node.left = new TreeNode(arr[i]);
                i++;
                queue.add(node.left);
            } else if (node.right == null) {
                node.right = new TreeNode(arr[i]);
                i++;
                queue.add(node.right);
            } else {
                queue.remove();
            }
        }
        return root;
    }

    public static void insertInOrder(TreeNode root, int d) {
        if (d <= root.val) {
            if (root.left == null) {
                root.left = new TreeNode(d);
            } else {
                insertInOrder(root.left, d);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(d);
            } else {
                insertInOrder(root.right, d);
            }
        }
    }
}
