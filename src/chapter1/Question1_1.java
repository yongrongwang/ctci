package chapter1;

/**
 * @author yongrong
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。给定一个string iniString，请返回一个bool值,True代
 * 表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 */
public class Question1_1 {

    /**
     * 用一个boolean数组表示字符串中字符是否第二次出现，如果是就立即返回false
     * @param iniString
     * @return
     */
    public static boolean checkDifferent(String iniString) {
        if (iniString.length() > 65536)
            return false;
        boolean[] char_flag = new boolean[65536];
        for (int i = 0; i < iniString.length(); i++) {
            int n = iniString.charAt(i);
            if (char_flag[n])
                return false;
            char_flag[n] = true;
        }
        return true;
    }

    /**
     * 使用位向量减少空间存储
     * @param iniString
     * @return
     */
    public static boolean checkDifferent2(String iniString) {
        if (iniString.length() > 65536)
            return false;
        long checker = 0;
        for (int i = 0; i < iniString.length(); i++) {
            long n = iniString.charAt(i) - '0';
            if ((checker & (1 << n)) > 0)
                return false;
            checker |= (1 << n);
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] words = { "hello", "world", "acbdbesy" };
        for (String w : words) {
            System.out.println(w + ": " + checkDifferent(w) + " " + checkDifferent2(w));
        }
    }

}
