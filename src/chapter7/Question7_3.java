package chapter7;

/**
 * @author yr
 * 给定直角坐标系上的两条直线，确定这两条直线会不会相交。线段以斜率和截距的形式给出，即double s1，double s2，double y1，double y2，分别
 * 代表直线1和2的斜率(即s1,s2)和截距(即y1,y2)，请返回一个bool，代表给定的两条直线是否相交。这里两直线重合也认为相交。
 */
public class Question7_3 {

    /**
     * 除了平行以外的都会相交
     * @param s1 直线1斜率
     * @param s2 直线2斜率
     * @param y1 直线1截距
     * @param y2 直线2截距
     * @return
     */
    public static boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        double s = 1e-12;
        // 不能直接用==来判断浮点数是否相等，应该检查两者差值是否小于一个极小值
        if (Math.abs(s1 - s2) < s && Math.abs(y1 - y2) > s) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double s1 = 2.0;
        double s2 = 2.0;
        double y1 = 4.0;
        double y2 = 5.0;
        System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", y1 = " + y1 + ", y2 = " + y2);
        System.out.println(checkCrossLine(s1, s2, y1, y2));
        s2 = 3.0;
        System.out.println("s1 = " + s1 + ", s2 = " + s2 + ", y1 = " + y1 + ", y2 = " + y2);
        System.out.println(checkCrossLine(s1, s2, y1, y2));
    }

}
