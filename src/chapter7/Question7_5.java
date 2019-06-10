package chapter7;

/**
 * @author yr
 * 在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。假定正方形的上下两条边与x轴平行。给定两个vecotrA和B，分别为两个正方
 * 形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。
 */
public class Question7_5 {

    /**
     * 题目保证斜率存在，问题简化了。设y = k * x + b，首先分别计算出两个正方形的中心点，经过中心点的一条直线可以将这两个正方形对半分
     * @param A
     * @param B
     * @return
     */
    public static double[] getBipartition(Point[] A, Point[] B) {
        double x1 = (A[0].x + A[1].x + A[2].x + A[3].x) / 4.0;
        double y1 = (A[0].y + A[1].y + A[2].y + A[3].y) / 4.0;
        double x2 = (B[0].x + B[1].x + B[2].x + B[3].x) / 4.0;
        double y2 = (B[0].y + B[1].y + B[2].y + B[3].y) / 4.0;
        double k = (y2 - y1) / (x2 - x1);
        double b = y1 - k * x1;
        double[] result = { k, b };
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Point[] A = { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0) };
        Point[] B = { new Point(1, 0), new Point(1, 1), new Point(2, 0), new Point(2, 1) };
        double[] result = getBipartition(A, B);
        System.out.println("slope = " + result[0] + ", intercept = " + result[1]);
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }
}