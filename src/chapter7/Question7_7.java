package chapter7;

import java.util.LinkedList;

/**
 * @author yr
 * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。给定一个数int k，请返回第k个数。保证k小于等于100。
 */
public class Question7_7 {
    public static int removeMin(LinkedList<Integer> queue) {
        Integer min = queue.peek();
        for (Integer v : queue) {
            if (v < min) {
                min = v;
            }
        }
        while (queue.contains(min)) {
            queue.remove(min);
        }
        return min;
    }

    public static void addProduct(LinkedList<Integer> queue, int v) {
        queue.add(3 * v);
        queue.add(5 * v);
        queue.add(7 * v);
    }

    /**
     * 从队列queue中找出最小值min且从队列中移除所有等于min的值，然后将3 * min、5 * min和7 * min添加到队列中
     * @param k
     * @return
     */
    public static int findKth(int k) {
        if (k < 0) {
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        addProduct(queue, 1);
        int min = 1;
        for (int i = 0; i < k; i++) {
            min = removeMin(queue);
            addProduct(queue, min);
        }
        return min;
    }

    /**
     * 分为三个队列queue3、queue5和queue7，每次从三个队列中取出最小值min，然后往取出最小值的队列无重复地添加数据3 * min，5 * min和
     * 7 * min，接下来要考虑无重复问题，假设最小值min是从queue7中取出来的，则min看起来像7 * v，所以必然已经处理过了3 * v和5 * v，当处理
     * 3 * v的时候，会将7 * 3 * v添加到队列queue7中，当处理5 * v的时候，会将7 * 5 * v添加到队列queue7中，所以当前情况只需要将
     * 7 * 7 * v放入队列queue7中即可。类似的，当最小值min是从queue5中取出的，只要将5 * 5 * min和5 * 7 * min添加到队列queue5中即可。
     * @param k
     * @return
     */
    public static int findKth2(int k) {
        if (k < 0) {
            return 0;
        }
        LinkedList<Integer> queue3 = new LinkedList<Integer>();
        LinkedList<Integer> queue5 = new LinkedList<Integer>();
        LinkedList<Integer> queue7 = new LinkedList<Integer>();
        queue3.add(1);
        int min = 0;
        // 迭代的时候包括第0个数到第k个数
        for (int i = 0; i <= k; i++) {
            int min3 = (queue3.size() == 0 ? Integer.MAX_VALUE : queue3.peek());
            int min5 = (queue5.size() == 0 ? Integer.MAX_VALUE : queue5.peek());
            int min7 = (queue7.size() == 0 ? Integer.MAX_VALUE : queue7.peek());
            min = Math.min(min3, Math.min(min5, min7));
            if (min == min3) {
                queue3.remove();
                queue3.add(3 * min);
                queue5.add(5 * min);
                queue7.add(7 * min);
            } else if (min == min5) {
                queue5.remove();
                queue5.add(5 * min);
                queue7.add(7 * min);
            } else {
                queue7.remove();
                queue7.add(7 * min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 20;
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + findKth(i) + " " + findKth2(i));
        }
    }

}
