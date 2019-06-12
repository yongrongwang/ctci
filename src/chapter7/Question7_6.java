package chapter7;

import java.util.HashMap;

/**
 * @author yr
 * 在二维平面上，有一些点，请找出经过点数最多的那条线。给定一个点集vector<point>p和点集的大小n,没有两个点的横坐标相等的情况,请返回一个
 * vector<double>，代表经过点数最多的那条直线的斜率和截距。</double></point>
 */
public class Question7_6 {

    /**
     * 没有两个点的横坐标相等的情况,简化了问题。由于斜率和截距是浮点数，所以判断两条直线的斜率和截距是否相等，需要使用浮点数比较大小的方式，构
     * 造一个class Line用来封装斜率和截距，用hashmap保存Line和累加值
     * @param p
     * @param n
     * @return 经过点数最多的那条直线的斜率和截距
     */
    public static double[] getLine(Point[] p, int n) {
        double e = 1e-6;
        int max = 0;
        double slope = 0;
        double intercept = 0;
        HashMap<Line, Integer> map = new HashMap<Line, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Line line = new Line(p[i], p[j]);
                boolean flag = false;
                for (Line l : map.keySet()) {
                    if (Math.abs(line.k - l.k) < e && Math.abs(line.b - l.b) < e) {
                        int num = map.get(l) + 1;
                        map.put(l, num);
                        if (num > max) {
                            max = num;
                            slope = l.k;
                            intercept = l.b;
                        }
                        flag = true;
                    }
                }
                if (flag == false) {
                    map.put(line, 1);
                }
            }
        }
        double[] result = { slope, intercept };
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 10;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            if (i < n / 2 + 1) {
                points[i] = new Point(i, 2 * i + 3);
            } else {
                points[i] = new Point(i, 3 * i + 2);
            }
        }
        double[] line = getLine(points, n);
        System.out.println("y = " + line[0] + " * x + " + line[1]);
    }

}

/**
 * @author yr
 * 用来封装斜率和截距
 */
class Line {
    double k;
    double b;

    // y = k * x + b
    public Line(Point a, Point b) {
        this.k = (double) (a.y - b.y) / (a.x - b.x);
        this.b = (double) a.y - k * a.x;
    }
}