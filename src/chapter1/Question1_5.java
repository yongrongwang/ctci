package chapter1;

/**
 * @author yongrong
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则
 * 返回原先的字符串。给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩
 * 后或未变化的串。
 */
public class Question1_5 {
    public static int countZip(String str) {
        if (str == null || str == "")
            return 0;
        int size = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                size += 1 + String.valueOf(count).length();
                last = str.charAt(i);
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();

        return size;
    }

    /**
     * 使用StringBuffer进行提高性能
     * @param iniString 
     * @return 
     */
    public static String zipString(String iniString) {
        int size = countZip(iniString);
        if (size >= iniString.length())
            return iniString;
        StringBuffer buffer = new StringBuffer();
        char last = iniString.charAt(0);
        int count = 1;

        for (int i = 1; i < iniString.length(); i++) {
            if (iniString.charAt(i) == last) {
                count++;
            } else {
                buffer.append(last); // 插入字符
                buffer.append(count); // 插入数字
                last = iniString.charAt(i);
                count = 1;
            }
        }
        buffer.append(last);
        buffer.append(count);

        return buffer.toString();
    }

    public static int setChar(char[] array, char c, int count, int index) {
        array[index++] = c;
        char[] countArr = String.valueOf(count).toCharArray();
        for (char x : countArr)
            array[index++] = x;

        return index;
    }

    /**
     * 不使用StringBuffer提高性能，算出压缩后字符串长度，构建相应大小数组
     * @param iniString
     */
    public static String zipString2(String iniString) {
        int size = countZip(iniString);
        if (size > iniString.length())
            return iniString;
        int index = 0;
        char[] array = new char[size];
        char last = iniString.charAt(0);
        int count = 1;

        for (int i = 1; i < iniString.length(); i++) {
            if (iniString.charAt(i) == last) {
                count++;
            } else {
                index = setChar(array, last, count, index);
                last = iniString.charAt(i);
                count = 1;
            }
        }
        setChar(array, last, count, index);

        return String.valueOf(array);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abbccccccde";
        String zipString = zipString(str);
        String zipString2 = zipString2(str);
        System.out.println("Old string (len = " + str.length() + "): " + str);
        System.out.println("Compressed string (len = " + zipString.length() + "): " + zipString);
        System.out.println("Compressed string (len = " + zipString2.length() + "): " + zipString2);
    }

}
