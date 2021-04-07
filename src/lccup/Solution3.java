package lccup;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3 {
    public int magicTower(int[] nums) {
        if (Arrays.stream(nums).sum() <= 0) {
            return -1;
        }
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 1;
        for (int num : nums) {
            if (num < 0) {
                queue.add(num);
            }
            sum += num;
            while (sum <= 0 || !queue.isEmpty()) {
                count++;
                sum -= queue.poll();
            }
            if (sum <= 0) {
                return -1;
            }
        }
        return count;
    }
}
