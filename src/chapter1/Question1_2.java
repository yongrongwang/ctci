package chapter1;

/**
 * @author yongrong
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。给定一个string iniString，请返回一个
 * string，为翻转后的字符串。保证字符串的长度小于等于5000。
 */

public class Question1_2 {

    /**
     * 首尾字符对调
     * @param iniString
     * @return
     */
    public static String reverseString(String iniString) {
        char[] charArr = iniString.toCharArray();
        for (int i = 0, j = charArr.length - 1; i < j; i++, j--) {
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] words = { "hello", "world", "acbdbesy", "This is nowcoder" };
        for (String w : words) {
            System.out.println(w + " ==> " + reverseString(w));
        }
    }

}
