package ctciLibrary;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode[] sortedListNodes(int length) {
        ListNode[] nodes = new ListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new ListNode(i);
        }
        return nodes;
    }

    public static ListNode[] randomListNodes(int length, int min, int max) {
        ListNode[] nodes = new ListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new ListNode(AsSortedMethods.randomIntInRange(min, max));
        }
        return nodes;
    }

    public static ListNode buildList(ListNode[] nodes, int length) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            nodes[i].next = ((i != length - 1) ? nodes[i + 1] : null);
        }
        return nodes[0];
    }

    public String printForward() {
        if (next != null) {
            return val + "->" + next.printForward();
        } else {
            return ((Integer) val).toString();
        }
    }
}
