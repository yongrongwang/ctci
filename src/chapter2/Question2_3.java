package chapter2;

import ctciLibrary.ListNode;

/**
 * @author yongrong
 * 实现一个算法，删除单向链表中间某个结点，假定你只能访问该结点。给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 */
public class Question2_3 {
    /**
     * 复制当前节点后一个节点的数据到当前节点，然后删除后一个节点
     * @param pNode 待删除的节点
     * @return 是否成功删除节点
     */
    public static boolean removeNode(ListNode pNode) {
        if (pNode == null || pNode.next == null)
            return false;
        ListNode next = pNode.next;
        pNode.val = next.val;
        pNode.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int length = 10;
        ListNode[] nodes = ListNode.randomListNodes(length, 1, length);
        ListNode head = ListNode.buildList(nodes, length);
        System.out.println(head.printForward());
        removeNode(head.next.next.next);
        System.out.println(head.printForward());
    }

}
