package chapter2;

import ctciLibrary.ListNode;

/**
 * @author yongrong
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果
 * 。给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 */
public class Question2_5 {
    /**
     * 使用递归的方法计算每个位置数值,将两个结点逐一相加，如果有进位则传递到下一个结点
     * @param a 链表a
     * @param b 链表b
     * @param carry 低位进位值
     * @return 求和后的链表
     */
    public static ListNode addLists(ListNode a, ListNode b, int carry) {
        if (a == null && b == null && carry == 0)
            return null;

        ListNode current = new ListNode(-1);
        int value = carry;
        if (a != null)
            value += a.val;
        if (b != null)
            value += b.val;
        current.val = value % 10;
        current.next = addLists(a == null ? null : a.next, b == null ? null : b.next, value < 10 ? 0 : 1);
        return current;
    }

    /**
     * @param a 链表a
     * @param b 链表b
     * @return 求和后的链表
     */
    public static ListNode plusAB(ListNode a, ListNode b) {
        if (a == null && b == null)
            return null;
        return addLists(a, b, 0);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int aLength = 3;
        ListNode[] aNodes = ListNode.randomListNodes(aLength, 0, 10);
        ListNode a = ListNode.buildList(aNodes, aLength);
        System.out.println("a = " + a.printForward());
        int bLength = 3;
        ListNode[] bNodes = ListNode.randomListNodes(bLength, 0, 10);
        ListNode b = ListNode.buildList(bNodes, bLength);
        System.out.println("b = " + b.printForward());
        ListNode sum = plusAB(a, b);
        System.out.println("sum = " + sum.printForward());
    }

}
