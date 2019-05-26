package chapter2;

import java.util.HashSet;

import ctciLibrary.ListNode;

/**
 * @author yongrong 
 * 移除未排序链表中重复节点
 */
public class Question2_1 {
    /**
     * 使用hashset保存遍历过程中遇到的所有节点，如果遇到了已经保存的节点就删除该节点
     * @param n 链表头结点
     */
    public static void deleteDups(ListNode n) {
        if (n == null)
            return;
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode previous = null;
        while (n != null) {
            if (set.contains(n.val)) {
                previous.next = n.next;
            } else {
                set.add(n.val);
                previous = n;
            }
            n = n.next;
        }
    }

    /**
     * 不用缓冲区，使用两个指针， current迭代访问整个链表，runner检查current后面的节点是否重复。时间复杂度增加了，所以是用时间换空间
     * @param n 链表头结点
     */
    public static void deleteDups2(ListNode n) {
        if (n == null)
            return;
        ListNode current = n;
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 8;
        ListNode[] nodes = new ListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new ListNode(i % 2);
        }
        ListNode head = ListNode.buildList(nodes, length);
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
    }

}
