package chapter2;

import ctciLibrary.AsSortedMethods;
import ctciLibrary.ListNode;

/**
 * @author yongrong
 * 请编写一个函数，返回环路的开头结点
 */
public class Question2_6 {
    /**
     * 采用两个指针fast和slow，fast一次走两步，slow一次走一步，两个指针必定在环内相遇，设链表中非环路部分为k，则相遇点为距离环路入口
     * K=k%loopSize处，此时两个指针都和环路入口相距k个结点，将slow指针指向链表头结点，slow和fast以相同的速度移动，则两个指针会在环路入口
     * 相遇
     * @param pHead 链表头结点
     * @return 环路入口结点
     */
    public static ListNode FindBeginning(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 找到相遇结点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        // 错误检测，没有相遇也就也没有环路
        if (fast == null || fast.next == null)
            return null;

        // slow指向链表头结点，fast指向相遇结点，以相同速度前进，再次相遇点为环路入口结点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 10;
        int k = AsSortedMethods.randomIntInRange(1, length);
        ListNode[] nodes = ListNode.sortedListNodes(length);
        for (int i = 0; i < length; i++) {
            nodes[i].next = ((i != length - 1) ? nodes[i + 1] : null);
        }
        nodes[length - 1].next = nodes[k - 1];
        ListNode head = nodes[0];
        ListNode beginning = FindBeginning(head);
        System.out.println("k = " + k);
        if (beginning != null) {
            System.out.println("Beginning of cycle is " + beginning.val);
        } else {
            System.out.println("No cycles");
        }
    }

}
