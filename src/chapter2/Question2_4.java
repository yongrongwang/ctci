package chapter2;

import ctciLibrary.AsSortedMethods;
import ctciLibrary.ListNode;

/**
 * @author yongrong
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前给定一个链表的头指针 ListNode* pHead，请返回重新排
 * 列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Question2_4 {
    /**
     * 创建两个链表before和after，before用来保存小于x的节点，after用来保存大于x的节点，将元素插入链表时采用尾插法，最后合并两个链表
     * @param pHead 头结点
     * @param x 给定的基准值x
     * @return 重新排列后的链表的头指针
     */
    public static ListNode partition(ListNode pHead, int x) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while (pHead != null) {
            ListNode next = pHead.next;
            pHead.next = null;
            // 将大于x的节点插入到before链表
            if (pHead.val < x) {
                if (beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = pHead;
                } else {
                    beforeEnd.next = pHead;
                    beforeEnd = beforeEnd.next;
                }
            }
            // 将小于x的节点插入到after链表
            else {
                if (afterStart == null) {
                    afterStart = pHead;
                    afterEnd = pHead;
                } else {
                    afterEnd.next = pHead;
                    afterEnd = afterEnd.next;
                }
            }
            pHead = next;
        }

        if (beforeStart == null)
            return afterStart;
        // 拼接两个链表
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    /**
     * 创建两个链表before和after，before用来保存小于x的节点，after用来保存大于x的节点，将元素插入链表时采用头插法，最后合并两个链表
     * @param pHead 头结点
     * @param x 给定的基准值x
     * @return 重新排列后的链表的头指针
     */
    public static ListNode partition2(ListNode pHead, int x) {
        ListNode beforeStart = null;
        ListNode afterStart = null;

        while (pHead != null) {
            ListNode next = pHead.next;
            if (pHead.val < x) {
                pHead.next = beforeStart;
                beforeStart = pHead;
            } else {
                pHead.next = afterStart;
                afterStart = pHead;
            }
            pHead = next;
        }

        if (beforeStart == null)
            return afterStart;
        // 定位到before链表的末尾
        ListNode beforeEnd = beforeStart;
        while (beforeEnd.next != null)
            beforeEnd = beforeEnd.next;
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    /**
     * 创建两个链表before和after，before用来保存小于x的节点，after用来保存大于x的节点，将元素插入before链表时采用头插法，
     * 将元素插入after链表时采用头插法，最后合并两个链表
     * @param pHead 头结点
     * @param x 给定的基准值x
     * @return 重新排列后的链表的头指针
     */
    public static ListNode partition3(ListNode pHead, int x) {
        ListNode head = pHead;
        ListNode tail = pHead;

        while (pHead != null) {
            ListNode next = pHead.next;
            if (pHead.val < x) {
                pHead.next = head;
                head = pHead;
            } else {
                tail.next = pHead;
                tail = pHead;
            }
            pHead = next;
        }

        // 拼接两个链表
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 10;
        int x = AsSortedMethods.randomIntInRange(1, length);
        ListNode[] nodes = ListNode.randomListNodes(length, 1, length);
        ListNode head = ListNode.buildList(nodes, length);
        System.out.println(head.printForward());
        System.out.println("Pation is " + x);
        ListNode start = partition(head, x);
        System.out.println(start.printForward());
    }

}
