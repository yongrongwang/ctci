package chapter5;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。给定两个整数int A，int B。请返回需要改变的数位个数。
 */
public class Question5_5 {
    /**
     * A和B异或后统计1的个数
     * @param A
     * @param B
     * @return
     */
    public static int calcCost(int A, int B) {
        int count = 0;
        for (int C = A ^ B; C != 0; C >>>= 1) {
            count += C & 1;
        }
        return count;
    }

    /**
     * 使用C = C & (C - 1)来去掉最低有效位的1 
     * @param A
     * @param B
     * @return
     */
    public static int calcCost2(int A, int B) {
        int count = 0;
        for (int C = A ^ B; C != 0; C = C & (C - 1)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = -23432;
        int b = 512512;
        System.out.println(a + " " + b);
        System.out.println(AsSortedMethods.toBinaryString(a));
        System.out.println(AsSortedMethods.toBinaryString(b));
        System.out.println("Required number of bits: " + calcCost(a, b) + " " + calcCost2(a, b));
    }

}
