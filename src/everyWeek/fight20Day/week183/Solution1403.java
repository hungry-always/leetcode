package everyWeek.fight20Day.week183;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
            count += nums[i];
            if (2 * count > sum) {
                return list;
            }
        }
        return new LinkedList<>();
    }

    @Test
    public void test() {
        System.out.println(minSubsequence(new int[]{4,4,7,6,7}));
    }
}
