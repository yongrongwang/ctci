package ctciLibrary;

import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label = 0;
    public ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
