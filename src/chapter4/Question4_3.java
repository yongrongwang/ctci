package chapter4;

/**
 * @author yr
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。给定一个有序序列int[] vals,请返回创建的二叉查找
 * 树的高度。
 */
public class Question4_3 {

    public static int buildMinimalBST(int[] vals) {
        if (vals == null || vals.length == 0) {
            return 0;
        }
        return build(vals, 0, vals.length - 1);
    }

    /**
     * 让数组中间元素作为根结点，左半部分作为左子树，右半部分作为右子树
     * @param vals
     * @param start
     * @param end
     * @return
     */
    public static int build(int[] vals, int start, int end) {
        if (start >= end) {
            return 1;
        }
        int mid = (start + end) / 2;
        int leftHeight = build(vals, start, mid - 1);
        int rightHeight = build(vals, mid + 1, end);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 3;
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = i;
        }
        System.out.println("Height of BST: " + buildMinimalBST(vals));
    }

}
