package chapter1;

import java.util.Arrays;

/**
 * @author yongrong
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。给定一个
 * string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 */
public class Question1_3 {

    public static String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    /**
     * 比较排序后的字符串
     * @param stringA
     * @param stringB
     * @return
     */
    public static boolean checkSam(String stringA, String stringB) {
        if (stringA == null || stringB == null || stringA.length() != stringB.length())
            return false;
        return sort(stringA).equals(sort(stringB));
    }

    /**
     * 比较两个字符串中字符出现的次数
     * @param stringA
     * @param stringB
     * @return
     */
    public static boolean checkSam2(String stringA, String stringB) {
        if (stringA == null || stringB == null || stringA.length() != stringB.length())
            return false;

        int[] letters = new int[65536];
        char[] arr = stringA.toCharArray();
        for (char c : arr)
            letters[c]++;
        for (int i = 0; i < stringB.length(); i++) {
            int n = stringB.charAt(i);
            if ((--letters[n]) < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[][] pairs = { { null, null }, { "apple", "papel" }, { "carrot", "tarroc" }, { "hello", "llloh" } };
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println(word1 + ", " + word2 + ": " + checkSam(word1, word2) + " " + checkSam2(word1, word2));
        }
    }

}
