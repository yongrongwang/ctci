package chapter3;

/**
 * @author yongrong 
 * 一个数组实现三个栈，分配大小可以固定
 */
public class Question3_1 {
    static int stackSize = 100;
    static int[] buffer = new int[3 * stackSize];
    static int[] stackPointer = { -1, -1, -1 };

    public static void push(int stackNum, int value) throws Exception {
        if (stackPointer[stackNum] == stackSize - 1)
            throw new Exception("Stack is full");
        stackPointer[stackNum]++;
        buffer[absTop(stackNum)] = value;
    }

    public static int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1)
            throw new Exception("Stack is empty");
        int value = buffer[absTop(stackNum)];
        buffer[absTop(stackNum)] = 0;
        stackPointer[stackNum]--;
        return value;
    }

    public static int peek(int stackNum) {
        return buffer[absTop(stackNum)];
    }

    public static boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    public static int absTop(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        push(2, 4);
        System.out.println("Peek 2: " + peek(2));
        push(0, 1);
        push(0, 2);
        push(0, 3);
        System.out.println("Peek 0: " + peek(0));
        pop(0);
        pop(0);
        System.out.println("Peek 0: " + peek(0));
    }

}
