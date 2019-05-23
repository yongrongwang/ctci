package chapter3;

import java.util.ArrayList;
import java.util.Stack;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。
 */
public class Question3_6 {

    /**
     * 首先从堆栈stack中弹出一个元素放入tmp，然后从数组numbers中不断弹出元素直到元素大于tmp，最后将tmp压入堆栈stack
     * @param numbers
     * @return
     */
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = numbers.length - 1;
        while (i >= 0) {
            int tmp = numbers[i--]; // 步骤一
            while (!stack.isEmpty() && stack.peek() > tmp) { // 步骤二
                numbers[++i] = stack.pop();
            }
            stack.push(tmp); // 步骤三
        }
        for (int j = 0; j < numbers.length; j++) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 10;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = AsSortedMethods.randomIntInRange(0, 99);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        ArrayList<Integer> list = twoStacksSort(numbers);
        System.out.println(list.toString());
    }

}
