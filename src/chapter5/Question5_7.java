package chapter5;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 数组A包含了0到n的所有整数，但其中缺失了一个。对于这个问题，我们设定限制，使得一次操作无法取得数组number里某个整数的完整内容。唯一的可用操
 * 作是询问数组中第i个元素的二进制的第j位(最低位为第0位)，该操作的时间复杂度为常数，请设计算法，在O(n)的时间内找到这个数。给定一个数组number
 * ，即所有剩下的数按从小到大排列的二进制各位的值，如A[0][1]表示剩下的第二个数二进制从低到高的第二位。同时给定一个int n，意义如题。请返回缺失
 * 的数。
 */
public class Question5_7 {

    /**
     * 移去一个数会导致最低有效位（LSB1）的1和0的失衡
     * @param numbers
     * @param n
     * @return
     */
    public static int findMissing(int[][] numbers, int n) {
        for (int i = 0; i < n; i++)
            if (i % 2 != numbers[i][0])
                return i;

        return n;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 100;
        int miss = AsSortedMethods.randomIntInRange(0, n);
        int[][] numbers = new int[n][];
        for (int i = 0; i < n; i++) {
            int temp = i;
            if (i >= miss) {
                temp++;
            }
            int len = Integer.toBinaryString(i).length();
            numbers[i] = new int[len];
            for (int j = 0; j < len; j++) {
                numbers[i][j] = temp & 1;
                temp >>>= 1;
            }
            for (int j = len - 1; j >= 0; j--) {
                System.out.print(numbers[i][j]);
            }
            System.out.println();
        }
        System.out.println("missing number: " + miss);
        System.out.println("find missing: " + findMissing(numbers, n));
    }

}
