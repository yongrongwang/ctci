package chapter7;

/**
 * @author yr
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。给定两个正整数int a,int b,同时给定一个int type代表运算的
 * 类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。请返回计算的结果，保证数据合法且结果一定在int范围内。
 */
public class Question7_4 {

    /**
     * 题目要求是两个正整数int a,int b，而且保证数据合法且结果一定在int范围内，所以简化了问题
     * @param a
     * @param b
     * @param type
     * @return
     */
    public static int calc(int a, int b, int type) {
        if (type == -1) {
            return minus(a, b);
        } else if (type == 1) {
            return multiply(a, b);
        } else {
            return divide(a, b);
        }
    }

    /**
     * 减法：a - b = a + (-1) * b，其中(-1) * b = b
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a, int b) {
        int neg = 0;
        while (b != 0) {
            neg += -1;
            b += -1;
        }
        return a + neg;
    }

    /**
     * 乘法：a * b = a个b累加
     * @param a
     * @param b
     * @return
     */
    public static int multiply(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }

    /**
     * 除法：a / b = x，则a = b * x = x个b累加
     * @param a
     * @param b
     * @return
     */
    public static int divide(int a, int b) {
        int x = 0;
        int sum = 0;
        while (sum + b <= a) {
            sum += b;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 8;
        int b = 4;
        int type = -1;
        System.out.println(a + " - " + b + " = " + calc(a, b, type));
        type = 1;
        System.out.println(a + " * " + b + " = " + calc(a, b, type));
        type = 0;
        System.out.println(a + " / " + b + " = " + calc(a, b, type));
    }

}
