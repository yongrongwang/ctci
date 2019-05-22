package chapter3;

import java.util.Stack;

import chapter3.StackWithMin.NodeWithMin;

public class StackWithMin extends Stack<NodeWithMin> {
    public class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int v, int m) {
            value = v;
            min = m;
        }
    }

    public void push(int value) {
        int minValue = Math.min(value, min());
        super.push(new NodeWithMin(value, minValue));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}
