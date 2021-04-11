package topic301_400;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution315 {
    Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> countSmaller(int[] nums) {
        int[] numbers = Arrays.stream(nums)
                .distinct()
                .sorted()
                .toArray();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        Arrays.fill(numbers, 0);
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            Integer index = map.get(num);
            nums[i] = getId(index, numbers);
            updateId(index, numbers);
        }
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
    }

    private void updateId(int num, int[] dp) {
        while (num <= dp.length - 1) {
            dp[num]++;
            num += lowBit(num + 1);
        }
    }

    private int getId(int num, int[] dp) {
        if (num == 0) {
            return 0;
        }
        int result = dp[num - 1];
        while (num > 0) {
            num -= lowBit(num);
            if (num <= 0) {
                break;
            }
            result += dp[num - 1];
        }
        return result;
    }

    private int lowBit(int x) {
        return -x & x;
    }

    @Test
    public void test() {
        int[] ints = {5, 2, 6, 1};
        List<Integer> list = countSmaller(ints);
        System.out.println(list);
    }
}
