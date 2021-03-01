package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution2_20 {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, int[]> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            int[] orDefault = map.getOrDefault(num, new int[]{i, i});
            orDefault[1] = i;
            map.put(num, orDefault);
        }
        int maxCount = countMap.values().stream()
                .mapToInt(Integer::valueOf)
                .max()
                .getAsInt();
        return map.entrySet().stream()
                .filter(entry -> countMap.get(entry.getKey()) == maxCount)
                .mapToInt(entry -> entry.getValue()[1] - entry.getValue()[0]+1)
                .min()
                .getAsInt();
    }

    @Test
    public void test() {
        int[] ints = {1,2,2,3,1,4,2};
        int shortestSubArray = findShortestSubArray(ints);
        System.out.println(shortestSubArray);
    }
}
