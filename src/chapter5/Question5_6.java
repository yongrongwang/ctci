package chapter5;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）给定一个int x，请返回交换后的数int。
 */
public class Question5_6 {
    /**
     * 分开处理，先处理奇数位后处理偶数位，使用0xaa（1010）作为掩码提取奇数位并右移，使用0x55（0101）作为掩码提取偶数位并左移，最后合并结果
     * @param x
     * @return
     */
    public static int exchangeOddEven(int x) {
        return ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = Integer.MIN_VALUE;
        int b = exchangeOddEven(a);
        System.out.println(a + ": " + AsSortedMethods.toBinaryString(a));
        System.out.println(b + ": " + AsSortedMethods.toBinaryString(b));
    }

}
