package chapter2;

import ctciLibrary.ListNode;

/**
 * @author yongrong
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Question2_2 {
    /**
     * 
     * @param head 链表首节点
     * @param k 倒数第几个节点
     * @return 倒数第k个节点
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k - 1; i++) {
            if (p1 == null)
                return null;
            p1 = p1.next;
        }
        if (p1 == null)
            return null;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 5;
        ListNode[] nodes = ListNode.randomListNodes(length, 1, length);
        ListNode head = ListNode.buildList(nodes, length);
        System.out.println(head.printForward());
        for (int k = 1; k <= length; k++)
            System.out.println("The " + k + "th to last node is " + FindKthToTail(head, k).val);
    }

}
