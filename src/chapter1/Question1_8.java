package chapter1;

/**
 * @author yongrong
 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为
 * s1旋转而成，要求只能调用一次检查子串的函数。给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大
 * 小写，字符串长度小于等于1000。
 */
public class Question1_8 {
    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * s1=xy，s2=yx，所以s2=yx是s1s1=xyxy子串
     * @param s1 
     * @param s2 
     * @return 
     */
    public static boolean checkReverseEqual(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length() || s1.length() == 0)
            return false;
        return isSubstring(s1 + s1, s2);
    }

    public static boolean checkReverseEqual2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length() || s1.length() == 0)
            return false;
        return (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[][] pairs = { { "apple", "pleap" }, { "waterbottle", "erbottlewat" }, { "camera", "macera" } };
        for (String[] p : pairs)
            System.out.println(p[0] + " " + p[1] + " is reverse equal? " + checkReverseEqual(p[0], p[1]) + " "
                    + checkReverseEqual2(p[0], p[1]));
    }

}
