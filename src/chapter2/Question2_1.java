package chapter2;

import java.util.HashSet;

import ctciLibrary.LinkedListNode;

/**
 * @author yongrong 
 * �Ƴ�δ���������е��ظ��ڵ�
 */
public class Question2_1 {
    /**
     * 使用hashset保存遍历过程中遇到的所有节点，如果遇到了已经保存的节点就删除该节点
     * @param n 链表头结点
     */
    public static void deleteDups(LinkedListNode n) {
        if (n == null)
            return;
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    /**
     * 不用缓冲区，使用两个指针， current迭代访问整个链表，runner检查current后面的节点是否重复。时间复杂度增加了，所以是用时间换空间
     * @param n 链表头结点
     */
    public static void deleteDups2(LinkedListNode n) {
        if (n == null)
            return;
        LinkedListNode current = n;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
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
        LinkedListNode head = new LinkedListNode(0, null, null);
        LinkedListNode first = head;
        LinkedListNode second = head;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPreviows(first);
            first = second;
        }
        LinkedListNode clone = head.clone();

        System.out.println(head.forward());
        deleteDups(head);
        System.out.println(head.forward());
        System.out.println(clone.forward());
        deleteDups2(clone);
        System.out.println(clone.forward());
    }

}
