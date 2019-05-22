package chapter3;

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
