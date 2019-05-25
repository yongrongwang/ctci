package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author yr
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b(请
 * 不要在意数据类型，图是有向图),请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */
public class Question4_2 {

    /**
     * 采用广度优先遍历的方法，要注意两点：图中可能会有环，所以访问过的结点要标记为ture；图是有向图，所以要分别检测两个方向
     * @param a
     * @param b
     * @return
     */
    public static boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        return check(a, b) || check(b, a);
    }

    public static boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
        if (a == null || b == null) {
            return false;
        }
        if (a == b) {
            return true;
        }
        HashMap<UndirectedGraphNode, Boolean> map = new HashMap<UndirectedGraphNode, Boolean>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        map.put(a, true);
        queue.add(a);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.removeFirst();
            if (node != null) {
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    if (neighbor == b) {
                        return true;
                    }
                    if (map.get(neighbor) == null) {
                        map.put(neighbor, true);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 5;
        UndirectedGraphNode[] nodes = new UndirectedGraphNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new UndirectedGraphNode(i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i != j) {
                    nodes[i].neighbors.add(nodes[j]);
                }
            }
        }
        System.out.println("check path: " + checkPath(nodes[0], nodes[n - 1]));
        for (int j = 0; j < n - 1; j++) {
            nodes[n - 1].neighbors.add(nodes[j]);
        }
        System.out.println("check path: " + checkPath(nodes[0], nodes[n - 1]));
    }

}

class UndirectedGraphNode {
    // 表示结点数值
    int label = 0;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
