package fight.day02;

import java.util.HashMap;
import java.util.Map;

public class Solution886 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        int[] sumArr = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : sumArr) {
            count += map.getOrDefault(num - k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
