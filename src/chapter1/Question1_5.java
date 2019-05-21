package chapter1;

/**
 * @author yongrong
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
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
     * 采用StringBuffer来避免反复进行字符串拼接操作的低效率
     * @param iniString 输入的字符串
     * @return 压缩后的字符串
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
                buffer.append(count); // 插入连续相同的字符个数
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
     * 如果不能用StringBuffer，则采用数组来避免反复进行字符串拼接操作的低效率
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
