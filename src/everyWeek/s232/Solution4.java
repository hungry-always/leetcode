package everyWeek.s232;

import org.junit.jupiter.api.Test;

import javax.swing.*;

public class Solution4 {
    public int maximumScore(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        int[] minArr = new int[n - k];
        for (int i = 0; i < minArr.length; i++) {
            minArr[i] = (i == 0) ? nums[k] : Math.min(minArr[i - 1], nums[k + i]);
        }
        for (int i = n - 1; i >= k; i--) {
            if (i + 1 < n - 1 && minArr[i - k] == minArr[i - k + 1]) {
                continue;
            }
            int min = minArr[i - k];
            for (int j = k; j >= 0; j--) {
                if (result >= (i - 0 + 1) * min) {
                    break;
                }
                min = Math.min(nums[j], min);
                result = Math.max(result, (i - j + 1) * min);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] numbers = {5, 5, 4, 5, 4, 1, 1, 1};
        int i = maximumScore(numbers, 0);
        System.out.println(i);
    }
}
