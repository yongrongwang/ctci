package chapter5;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 有一个正整数，请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小)给定正整数int x，请返回一个vector，代表所求的
 * 两个数（小的在前）。保证答案存在。
 */
public class Question5_3 {

    /**
     * 
     * @param x
     * @return
     */
    public static int[] getCloseNumber(int x) {
        int[] result = new int[2];
        result[0] = getPrev(x);
        result[1] = getNext(x);
        return result;
    }

    /**
     * 获取前一个略小的数，假设数字为110010001111，p表示需要翻转的最右边但是非拖尾的1变为0的位置，c0表示在p右边0的个数，c1表示在p右边1的个
     * 数，分为四步：（1）计算c0和c1，（2）将位置p处的1变成0，（3）将p右边所有位清0，（4）在p右边高位插入c1+1个1
     * @param x
     * @return
     */
    public static int getPrev(int x) {
        int temp = x;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        // 当数值形如00001111时候，没有办法再变小
        if (temp == 0) {
            return -1;
        }
        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }
        // 计算最右边非拖尾的1的位置
        int p = c0 + c1;
        // 将最右边非拖尾的1变为0
        x &= (~(1 << p));
        // 将位置p右边所有位清0
        x &= ((~0) << p);
        // p右边高位插入c1+1个1，c0-1个0
        int mask = ((1 << (c1 + 1)) - 1);
        x |= (mask << (c0 - 1));

        return x;
    }

    /**
     * 获取后一个略大的数，假设数字为110111001100，p表示需要翻转的最右边但是非拖尾的0变为1的位置，c0表示在p右边0的个数，c1表示在p右边1的个
     * 数，分为四步：（1）计算c0和c1，（2）将位置p处的0变成1，（3）将p右边所有位清0，（4）在p右边低位插入c1-1个1
     * @param x
     * @return
     */
    private static int getNext(int x) {
        int temp = x;
        int c0 = 0;
        int c1 = 0;

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        // 当数值形如11110000时候，没有办法再变大
        if (c0 + c1 == 32 || c0 + c1 == 0) {
            return -1;
        }
        // 计算最右边非拖尾的0的位置
        int p = c0 + c1;
        // 将位置p处的0变成1
        x |= (1 << p);
        // 将p右边所有位清0
        x &= ((~0) << p);
        // 在p右边低位插入c1-1个1
        x |= ((1 << (c1 - 1)) - 1);
        return x;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 0b110010001111;
        int[] result = getCloseNumber(x);
        System.out.println("原来的数： " + AsSortedMethods.toBinaryString(x));
        System.out.println("略小的数： " + AsSortedMethods.toBinaryString(result[0]));
        System.out.println("略大的数： " + AsSortedMethods.toBinaryString(result[1]));
    }

}
