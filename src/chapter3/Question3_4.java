package chapter3;

import java.util.Stack;

public class Question3_4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 3;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);
    }

}

class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int i) {
        disks = new Stack<Integer>();
        index = i;
    }

    public void add(int v) {
        if (!disks.isEmpty() && disks.peek() <= v) {
            System.out.println("Error placing dist " + v);
        }
        disks.push(v);
    }

    /**
     * 将origin顶端的盘子移动到destination
     * @param destination 目的地
     */
    public void moveTop(Tower destination) {
        Integer top = disks.pop();
        destination.add(top);
        System.out.println("Move top " + top + " from " + index + " to " + destination.index);
    }

    /**
     * 先将origin顶端n-1个盘子移动到buffer，以destination为缓冲区
     * 然后将origin顶端的盘子移动到destination
     * 最后将buffer顶端n-1个盘子移动到destination，以origin为缓冲区
     * @param n 盘子个数
     * @param destination 目的地
     * @param buffer 缓冲区
     */
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTop(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}