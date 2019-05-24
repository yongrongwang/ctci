package chapter1;

import ctciLibrary.AsSortedMethods;

/**
 * @author yongrong
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，请返
 * 回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，矩阵中的元素为int范围内。</int></vector></int></vector>
 */
public class Question1_7 {
    /**
     * 第一次遍历数组记录包含零元素的所有行和列，第二次遍历数组的时候将所在行和列清零
     * @param mat 矩阵
     * @param n 
     * @return 
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
