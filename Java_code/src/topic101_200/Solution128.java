package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 1;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int count = 0;
                while (set.contains(num + count)) {
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
