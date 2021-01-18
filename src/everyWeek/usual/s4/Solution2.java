package everyWeek.usual.s4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution2 {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) != -1) {
                int i = k - key;
                if (key == i) {
                    Integer integer = map.get(key);
                    count += (integer / 2);
                    map.put(key, -1);
                } else {
                    count += Math.min(map.getOrDefault(i, 0), map.get(key));
                    map.put(key, -1);
                    if (map.get(i) != null) {
                        map.put(i, -1);
                    }
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] ints = {3,1,3,4,3};
        int i = maxOperations(ints, 6);
        System.out.println(i);
    }
}
