package chapter9;

/**
 * @author yr
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果
 * Mod 1000000007给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 */
public class Question9_1 {

    /**
     * 用一个数组保存中间结果，空间换时间，递归变迭代，然后将数组用三个变量代替
     * @param n
     * @return
     */
    public static int countWays(int n) {
        int x = 1000000007;
        // 存储中间结果的三个变量
        int[] a = { 1, 2, 4 };
        if (n <= 0)
            return 0;
        if (n == 1)
            return a[0];
        if (n == 2)
            return a[1];
        if (n == 3)
            return a[2];
        for (int i = 4; i <= n; i++) {
            int t = ((a[0] + a[1]) % x + a[2]) % x;
            a[0] = a[1];
            a[1] = a[2];
            a[2] = t;
        }
        return a[2];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 36196;
        for (int i = 1; i <= 36196; i++) {
            long t1 = System.currentTimeMillis();
            int c1 = countWays(i);
            long t2 = System.currentTimeMillis();
            long d1 = t2 - t1;
            System.out.println(i + ": " + "c1 = " + c1 + ", d1 = " + d1 + " ");
        }
    }

}
