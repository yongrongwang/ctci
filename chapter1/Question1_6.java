package chapter1;

import ctciLibrary.AsSortedMethods;

/**
 * @author yongrong
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 */

public class Question1_6 {
    /**
     * 从最外层开始，在每一层上按照索引一个一个进行转换
     * @param mat 矩阵
     * @param n 矩阵长
     * @return 旋转后的矩阵
     */
    public static int[][] transformImage(int[][] mat, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                // 存储上面
                int top = mat[first][i];
                // 左到上
                mat[first][i] = mat[last - offset][first];
                // 下到左
                mat[last - offset][first] = mat[last][last - offset];
                // 右到下
                mat[last][last - offset] = mat[i][last];
                // 上到右
                mat[i][last] = top;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = AsSortedMethods.randomMatrix(10, 10, 0, 9);
        AsSortedMethods.printMatrix(matrix);
        System.out.println("After rotation");
        AsSortedMethods.printMatrix(transformImage(matrix, 10));
    }

}
