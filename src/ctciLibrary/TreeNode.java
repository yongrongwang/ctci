package ctciLibrary;

public class TreeNode {
    public int data;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    private int size;

    public TreeNode(int data) {
        this.data = data;
        this.size = 1;
    }

    public void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public static TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.setLeftChild(createMinimalBST(arr, start, mid - 1));
        root.setRightChild(createMinimalBST(arr, mid + 1, end));
        return root;
    }
}
