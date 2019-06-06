package chapter5;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 有两个32位整数n和m，请编写算法将m的二进制数位插入到n的二进制的第j到第i位,其中二进制的位数从低位数到高位且以0开始。给定两个数int n和
 * int m，同时给定int j和int i，意义如题所述，请返回操作后的数，保证n的第j到第i位均为零，且m的二进制位数小于等于i-j+1。
 */
public class Question5_1 {

    /**
     * i >= j，对M执行左移位操作，进行相应位对齐，然后合并
     * @param n
     * @param m
     * @param j
     * @param i
     * @return
     */
    public static int binInsert(int n, int m, int j, int i) {
        int mShifted = m << j;
        return n | mShifted;
    }

    /**
     * i >= j，设置掩码，类似于11100011，先生成左半部分11100000，再生成右半部分00000011，然后或运算生成整个掩码11100011
     * @param n
     * @param i
     * @param j
     * @return
     */
    public static int clear(int n, int i, int j) {
        if (i > 31 || i < 0 || j > 31 || j < 0 || i < j) {
            return -1;
        }
        int allOnes = ~0;
        int left = allOnes << (i + 1);
        int right = (1 << j) - 1;
        int mask = left | right;
        return n & mask;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 63;
        int m = 4;
        int i = 3;
        int j = 1;
        System.out.println("n = " + n + ", m = " + m + ", i = " + i + ", j = " + j);
        System.out.println(AsSortedMethods.toBinaryString(n));
        System.out.println(AsSortedMethods.toBinaryString(m));
        int nCleared = clear(n, i, j);
        int nInserted = binInsert(nCleared, m, j, i);
        System.out.println("After cleared: " + AsSortedMethods.toBinaryString(nCleared));
        System.out.println("After inserted: " + AsSortedMethods.toBinaryString(nInserted));
    }

}
