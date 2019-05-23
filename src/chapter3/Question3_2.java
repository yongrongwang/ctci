package chapter3;

import java.util.Stack;

import chapter3.StackWithMin.NodeWithMin;
import ctciLibrary.AsSortedMethods;

public class Question3_2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StackWithMin stack = new StackWithMin();
        int num = 15;
        for (int i = 0; i < num; i++) {
            int value = AsSortedMethods.randomIntInRange(0, 100);
            stack.push(value);
            System.out.print(stack.peek().value + ", ");
        }
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.println("min = " + stack.min());
            System.out.println("poped = " + stack.pop().value);
        }
    }

}

class StackWithMin extends Stack<NodeWithMin> {
    public class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int v, int m) {
            value = v;
            min = m;
        }
    }

    /**
     * 将value和min作为一个整体一起压入堆栈
     * @param value
     */
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
