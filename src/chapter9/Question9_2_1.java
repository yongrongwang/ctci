package chapter9;

/**
 * @author yr
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。给定两个正整数
 * int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 */
public class Question9_2_1 {
    /**
     * 因为只能走格点，所以可以理解起点为(1,1)，由于x＋y小于等于12，所以可以使用递归的方法，采用逆向思维，从右下角(x,y)向左上角走，可以向左
     * 走(x-1,y)向上走(x,y-1)，当走到边缘(x == 1 || y == 1)的时候就停止
     * @param x
     * @param y
     * @return
     */
    public static int countWays(int x, int y) {
        if (x <= 0 || y <= 0)
            return 0;
        if (x == 1 || y == 1)
            return 1;
        return countWays(x - 1, y) + countWays(x, y - 1);
    }

    /**
     * 动态规划解决，使用一个数组保存中间结果
     * @param x
     * @param y
     * @return
     */
    public static int countWays2(int x, int y) {
        int[][] result = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = 1;
                } else if (i != 0 && j == 0) {
                    result[i][j] = result[i - 1][j];
                } else if (i == 0 && j != 0) {
                    result[i][j] = result[i][j - 1];
                } else {
                    result[i][j] = (result[i - 1][j] + result[i][j - 1]) % 1000000007;
                }
            }
        }
        return result[x - 1][y - 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 10;
        int y = 10;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (i == j) {
                    System.out.println(
                            "x = " + i + ", y = " + j + ", c1 = " + countWays(i, j) + ", c2 = " + countWays2(i, j));
                }
            }
        }
    }

}
