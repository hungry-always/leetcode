package everyWeek.usual.s9;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution2 {
    public int tupleSameProduct(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        for (Integer value : map.values()) {
            if (value >= 2) {
                count += value * (value - 1) / 2;
            }
        }
        return count * 8;
    }

    @Test
    public void test() {
        int[] ints = {2, 3, 4, 6};
        System.out.println(tupleSameProduct(ints));
    }
}
