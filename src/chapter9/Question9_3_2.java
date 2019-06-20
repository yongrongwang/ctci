package chapter9;

import java.util.Arrays;

/**
 * @author yr
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个不下降序列，元素值可能相同，编写一个方法，判断在数组A中是否存在魔术索引。请
 * 思考一种复杂度优于o(n)的方法。给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 */
public class Question9_3_2 {
    /**
     * 不下降序列，元素值可能相同，使用改进后的二分法，先比较midIndex和midValue，如果不同则递归搜索左右两部分，
     * 左半部分：搜索索引从start到min(minIndex - 1, midValue)
     * 右半部分：搜索索引从max(minIndex + 1, midValue)到end
     * @param A
     * @param start
     * @param end
     * @return
     */
    public static boolean find(int[] A, int start, int end) {
        if (start > end || start < 0 || end > A.length - 1) {
            return false;
        }
        int midIndex = (start + end) / 2;
        int midValue = A[midIndex];
        if (midValue == midIndex) {
            return true;
        }
        // 搜索左半部分和右半部分
        return find(A, start, Math.min(midIndex - 1, midValue)) || find(A, Math.max(midIndex + 1, midValue), end);
    }

    /**
     * @param A
     * @param n
     * @return
     */
    public static boolean findMagicIndex(int[] A, int n) {
        if (n <= 0) {
            return false;
        }
        return find(A, 0, n - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = { -1, 0, 1, 2, 3, 4, 6, 6, 8, 8, 9, 10, 11 };
        int n = A.length;
        System.out.println(Arrays.toString(A));
        System.out.println(findMagicIndex(A, n));
    }

}
