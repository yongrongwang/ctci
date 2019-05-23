package chapter3;

import java.util.Stack;

import ctciLibrary.AsSortedMethods;

/**
 * @author yr 
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。笔记收藏纠错
 */
public class Question3_5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyQueue<Integer> queue = new MyQueue<Integer>();
        int n = 10;
        System.out.print("Enqueue element: ");
        for (int i = 0; i < n; i++) {
            int element = AsSortedMethods.randomIntInRange(0, 9);
            queue.push(element);
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.print("Dequeue element: ");
        for (int i = 0; i < n; i++) {
            int element = queue.pop();
            System.out.print(element + " ");
        }
    }

}

class MyQueue<T> {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 直接将元素压入stack1中
     * @param node 压入的元素
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 如果stack2中为空，则从stack1中弹出所有元素并压入stack2中，然后从stack2中弹出一个元素
     * @return stack2中弹出的元素
     */
    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}