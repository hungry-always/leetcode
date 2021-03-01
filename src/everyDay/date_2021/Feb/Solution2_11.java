package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2_11 {
    @Test
    public void test() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println("");
    }
}
class KthLargest {
    Queue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        size = k;
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > size) {
            queue.poll();
        }
        return queue.peek();
    }
}
