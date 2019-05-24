package chapter2;

import ctciLibrary.LinkedListNode;

/**
 * @author yongrong
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前给定一个链表的头指针 ListNode* pHead，请返回重新排列后的
 * 链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Question2_4 {
    /**
     * 创建两个链表before和after，before用来保存小于x的节点，after用来保存大于x的节点，将元素插入链表时采用尾插法，最后合并两个链表
     * @param pHead 头结点
     * @param x 给定的基准值x
     * @return 重新排列后的链表的头指针
     */
    public static LinkedListNode partition(LinkedListNode pHead, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (pHead != null) {
            LinkedListNode next = pHead.next;
            pHead.next = null;
            // 将大于x的节点插入到before链表
            if (pHead.data < x) {
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
    public static LinkedListNode partition2(LinkedListNode pHead, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;

        while (pHead != null) {
            LinkedListNode next = pHead.next;
            if (pHead.data < x) {
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
        LinkedListNode beforeEnd = beforeStart;
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
    public static LinkedListNode partition3(LinkedListNode pHead, int x) {
        LinkedListNode head = pHead;
        LinkedListNode tail = pHead;

        while (pHead != null) {
            LinkedListNode next = pHead.next;
            if (pHead.data < x) {
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
        int[] vals = { 1, 4, 10, 9, 6, 3, 8, 2, 12 };
        int x = 6;
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++)
            current = new LinkedListNode(vals[i], null, current);
        LinkedListNode head2 = head.clone();
        LinkedListNode head3 = head.clone();

        System.out.println(head.forward());
        LinkedListNode start = partition(head, x);
        System.out.println("Pation is " + x);
        System.out.println(start.forward());
        System.out.println();
        System.out.println(head2.forward());
        LinkedListNode start2 = partition2(head2, x);
        System.out.println("Pation is " + x);
        System.out.println(start2.forward());
        System.out.println();
        System.out.println(head3.forward());
        LinkedListNode start3 = partition3(head3, x);
        System.out.println("Pation is " + x);
        System.out.println(start3.forward());
    }

}
