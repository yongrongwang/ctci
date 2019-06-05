package chapter4;

import java.util.ArrayList;

import ctciLibrary.TreeNode;

/**
 * @author yr
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一
 * 条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Question4_9 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 3;
        int[] array = TreeNode.sortedArray(length);
        TreeNode root = TreeNode.createTreeFromArray(array, length);
        int t1 = 2;
        int t2 = 3;
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        System.out.println("t1 = " + t1 + ": " + tree1.FindPath(root, t1));
        System.out.println("t2 = " + t2 + ": " + tree2.FindPath(root, t2));
    }

}

class Tree {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();

    /**
     * 使用path保存根结点到当前结点路径上的所有节点，如果当前节点为叶子节点且list中的所有节点之和为target，则将path保存到lists 
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        // 将当前节点加入path
        path.add(root.val);
        // 如果是叶子节点
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }
            if (sum == target) {
                lists.add(new ArrayList<Integer>(path));
            }
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return lists;
    }
}