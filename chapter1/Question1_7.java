package chapter1;

import ctciLibrary.AsSortedMethods;

/**
 * @author yongrong
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，
 * 请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，矩阵中的元素为int范围内。</int></vector></int></vector>
 */
public class Question1_7 {
    /**
     * 第一次遍历分别用两个数组记录包含零元素的行和列，第二次遍历将相应的行和列标记为零
     * @param mat 输入的矩阵
     * @param n 矩阵的阶数
     * @return 清零后的矩阵
     */
    public static int[][] clearZero(int[][] mat, int n) {
        boolean[] rows = new boolean[n];
        boolean[] columns = new boolean[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (rows[i] || columns[j])
                    mat[i][j] = 0;
        return mat;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 10;
        int[][] matrix = AsSortedMethods.randomMatrix(n, n, 0, 100);
        AsSortedMethods.printMatrix(matrix);
        System.out.println("After set zeros");
        AsSortedMethods.printMatrix(clearZero(matrix, n));
    }

}
