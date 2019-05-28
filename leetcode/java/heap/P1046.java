package leetcode.java.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1046 {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int stone : stones) {
            queue.add(stone);
        }
        while(queue.size() > 1) {
            int x = queue.poll(), y = queue.poll();
            if(x != y) {
                queue.add(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }

}
