package chapter7;

/**
 * @author yr
 * 在n个顶点的多边形上有n只蚂蚁，这些蚂蚁同时开始沿着多边形的边爬行，请求出这些蚂蚁相撞的概率。(这里的相撞是指存在任意两只蚂蚁会相撞)给定一个
 * int n(3<=n<=10000)，代表n边形和n只蚂蚁，请返回一个double，为相撞的概率。
 */
public class Question7_2 {

    /**
     * 先计算不会碰撞的概率，不会碰撞的情况可以分为顺时针和逆时针两种情况，然后计算碰撞的概率
     * @param n
     * @return
     */
    public static double antsCollision(int n) {
        return 1.0 - Math.pow(0.5, n - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 50;
        System.out.println("n = " + n);
        System.out.println("collision of ants is " + antsCollision(n));
    }

}
