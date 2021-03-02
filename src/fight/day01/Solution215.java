package fight.day01;

import java.util.PriorityQueue;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() == k) {
                queue.add(num);
                queue.poll();
            }
        }
        return queue.peek();
    }
}
