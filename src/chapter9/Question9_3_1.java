package chapter9;

import java.util.Arrays;

/**
 * @author yr
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。请思
 * 考一种复杂度优于o(n)的方法。给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 */
public class Question9_3_1 {
    /**
     * 升序数组，元素值各不相同，可以使用二分法
     * @param A
     * @param n
     * @return
     */
    public static boolean findMagicIndex(int[] A, int n) {
        if (n <= 0) {
            return false;
        }
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == mid) {
                return true;
            } else if (A[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = { -1, 0, 1, 2, 3, 4, 6, 8, 9, 10, 11 };
        int n = A.length;
        System.out.println(Arrays.toString(A));
        System.out.println(findMagicIndex(A, n));
    }

}
