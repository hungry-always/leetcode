package everyWeek.s3;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution2 {
    public int maximumUniqueSubarray(int[] nums) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (!set.contains(num)) {
                queue.add(new int[]{num, sum});
            } else {
                while (true) {
                    int[] poll = queue.poll();
                    set.remove(poll[0]);
                    if (poll[0] == num) {
                        sum -= poll[1];
                        break;
                    }
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    @Test
    public void test() {
        int[] ints = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        int i = maximumUniqueSubarray(ints);
        System.out.println(i);
    }
}
