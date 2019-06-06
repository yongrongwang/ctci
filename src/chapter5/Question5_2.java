package chapter5;

/**
 * @author yr
 * 有一个介于0和1之间的实数，类型为double，返回它的二进制表示。如果该数字无法精确地用32位以内的二进制表示，返回“Error”。给定一个double num
 * ，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。
 */
public class Question5_2 {

    /**
     * 乘2取余法
     * @param num
     * @return
     */
    public static String printBin(double num) {
        if (num <= 0 || num >= 1) {
            return "Error";
        }
        StringBuilder binary = new StringBuilder();
        binary.append("0.");
        while (num > 0) {
            if (binary.length() > 32) {
                return "Error";
            }
            double r = num * 2;
            if (r >= 1) {
                num = r - 1;
                binary.append("1");
            } else {
                num = r;
                binary.append("0");
            }
        }
        return binary.toString();
    }

    /**
     * 和0.5比较，然后和0.25比较，以此类推
     * @param num
     * @return
     */
    public static String printBin2(double num) {
        if (num <= 0 || num >= 1) {
            return "Error";
        }
        StringBuilder binary = new StringBuilder();
        binary.append("0.");
        double frac = 0.5;
        while (num > 0) {
            if (binary.length() > 32) {
                return "Error";
            }
            if (num >= frac) {
                num = num - frac;
                binary.append("1");
            } else {
                binary.append("0");
            }
            frac /= 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double num = 0.03125;
        System.out.println(num + ": " + printBin(num) + ", " + printBin2(num));
    }

}
