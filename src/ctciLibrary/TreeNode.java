package ctciLibrary;

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

    public static TreeNode createMinimalBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalBST(arr, start, mid - 1);
        node.right = createMinimalBST(arr, mid + 1, end);
        return node;
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
