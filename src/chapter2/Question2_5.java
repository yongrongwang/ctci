package chapter2;

import ctciLibrary.AsSortedMethods;
import ctciLibrary.LinkedListNode;

/**
 * @author yongrong
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。给定
 * 两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 */
public class Question2_5 {
    /**
     * 使用递归的方法计算每个位置数值,将两个结点逐一相加，如果有进位则传递到下一个结点
     * @param a 链表a
     * @param b 链表b
     * @param carry 低位进位值
     * @return 求和后的链表
     */
    public static LinkedListNode addLists(LinkedListNode a, LinkedListNode b, int carry) {
        if (a == null && b == null && carry == 0)
            return null;

        LinkedListNode current = new LinkedListNode();
        int value = carry;
        if (a != null)
            value += a.data;
        if (b != null)
            value += b.data;
        current.data = value % 10;
        current.next = addLists(a == null ? null : a.next, b == null ? null : b.next, value < 10 ? 0 : 1);
        return current;
    }

    /**
     * @param a 链表a
     * @param b 链表b
     * @return 求和后的链表
     */
    public static LinkedListNode plusAB(LinkedListNode a, LinkedListNode b) {
        if (a == null && b == null)
            return null;

        return addLists(a, b, 0);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedListNode a = AsSortedMethods.randomLinkedList(3, 0, 10);
        System.out.println("a = " + a.forward());
        LinkedListNode b = AsSortedMethods.randomLinkedList(6, 0, 10);
        System.out.println("b = " + b.forward());
        LinkedListNode sum = plusAB(a, b);
        System.out.println("sum = " + sum.forward());
    }

}
