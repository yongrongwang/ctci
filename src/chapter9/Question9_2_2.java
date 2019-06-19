package chapter9;

/**
 * @author yr
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些
 * 障碍点是不能走的。给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。另外给定int x,
 * int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
 */
public class Question9_2_2 {
    /**
     * 动态规划解决，使用一个数组保存中间结果，多了一个判断条件
     * @param map
     * @param x
     * @param y
     * @return
     */
    public static int countWays(int[][] map, int x, int y) {
        int[][] result = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // 多了一个判断条件
                if (map[i][j] != 1) {
                    continue;
                } else if (i == 0 && j == 0) {
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
        int[][] map = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
        int x = 11;
        int y = 4;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("x = " + x + ", y = " + y + ", c1 = " + countWays(map, x, y));
    }

}
