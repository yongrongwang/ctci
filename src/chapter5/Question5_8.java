package chapter5;

import java.util.Arrays;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 有一个单色屏幕储存在一维数组中，其中数组的每个元素代表连续的8位的像素的值，请实现一个函数，将第x到第y个像素涂上颜色(像素标号从零开始)，并尝
 * 试尽量使用最快的办法。给定表示屏幕的数组screen(数组中的每个元素代表连续的8个像素，且从左至右的像素分别对应元素的二进制的从低到高位)，以及
 * int x,int y，意义如题意所述，保证输入数据合法。请返回涂色后的新的屏幕数组。
 */
public class Question5_8 {

    /**
     * 从第x位到第y位，每8个位进行一次分组，每组中的每一位都要和1进行与操作
     * @param screen
     * @param x
     * @param y
     * @return
     */
    public static int[] renderPixel(int[] screen, int x, int y) {
        for (int i = x; i <= y; i++) {
            int m = i / 8;
            int n = i % 8;
            screen[m] |= (1 << n);
        }
        return screen;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 5;
        int x = AsSortedMethods.randomIntInRange(0, 8 * n - 1);
        int y = AsSortedMethods.randomIntInRange(x, 8 * n - 1);
        System.out.println("x = " + x + ", y = " + y);
        int[] screen = new int[n];
        for (int i = 0; i < n; i++) {
            screen[i] = AsSortedMethods.randomIntInRange(0, 255);
            for (int j = 0; j < 8; j++) {
                System.out.print((screen[i] >> j) & 1);
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(screen));
        int[] renderPixel = renderPixel(screen, x, y);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print((renderPixel[i] >> j) & 1);
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(renderPixel));
    }

}
