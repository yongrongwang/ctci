package chapter4;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖
 * 先的编号。给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
 */
public class Question4_7 {

    /**
     * 满二叉树的父节点和子节点关系为root = child / 2，如果a != b，则将较大者除以2，如此循环直到a == b 
     * @param a
     * @param b
     * @return
     */
    public static int getLCA(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a / 2;
            } else if (b > a) {
                b = b / 2;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 10;
        for (int i = 0; i < n; i++) {
            int a = AsSortedMethods.randomIntInRange(1, n);
            int b = AsSortedMethods.randomIntInRange(1, n);
            System.out.println("a = " + a + ", " + "b = " + b + ", ancestor = " + getLCA(a, b));
        }
    }

}
