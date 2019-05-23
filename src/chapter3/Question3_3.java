package chapter3;

import java.util.ArrayList;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr
 * 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
 * 给定一个操作序列int[][2]ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，
 * 后一个数无意义。请返回一个int[][](C++为vector&ltvector&ltint>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
public class Question3_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int size = 5;
        int[][] ope = new int[25][2];
        for (int i = 0; i < 25; i++) {
            if (i < 20) {
                ope[i][0] = 1;
                ope[i][1] = AsSortedMethods.randomIntInRange(0, 9);
                System.out.print(ope[i][1] + " ");
                if ((i % size) == (size - 1)) {
                    System.out.println();
                }
            } else {
                ope[i][0] = 2;
                ope[i][1] = 0;
            }
        }
        System.out.println();
        SetOfStacks set = new SetOfStacks();
        ArrayList<ArrayList<Integer>> stacks = set.setOfStacks(ope, size);
        for (ArrayList<Integer> stack : stacks) {
            for (Integer s : stack) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}

class SetOfStacks {
    ArrayList<ArrayList<Integer>> stacks = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) {
                push(size, ope[i][1]);
            }
            if (ope[i][0] == 2) {
                pop();
            }
        }
        return stacks;
    }

    public ArrayList<Integer> getLast() {
        if (stacks.size() == 0) {
            return null;
        } else {
            return stacks.get(stacks.size() - 1);
        }
    }

    /**
     * 若最后一个堆栈满了，就新建一个新的堆栈，否则直接压入最后一个堆栈
     * @param size 堆栈大小
     * @param value 压入数值
     */
    public void push(int size, int value) {
        ArrayList<Integer> last = getLast();
        if (last != null && last.size() != size) {
            last.add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            stacks.add(list);
            list.add(value);
        }
    }

    /**
     * 直接从最后一个堆栈弹出一个元素，若最后一个堆栈为空，就删除最后一个堆栈
     * @return 弹出的元素
     */
    public int pop() {
        ArrayList<Integer> last = getLast();
        int v = last.remove(last.size() - 1);
        if (last.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }
}
