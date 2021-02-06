package everyWeek.usual.s3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution2 {
    public int maximumUniqueSubarray(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            queue.add(num);
            if (!set.contains(num)) {
                set.add(num);
            } else {
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    sum -= poll;
                    if (poll == num) {
                        break;
                    }
                    set.remove(poll);
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    @Test
    public void test() {
        int[] ints = {4, 1, 4, 5, 4, 4, 6, 2, 2};
        int i = maximumUniqueSubarray(ints);
        System.out.println(i);
    }
}
