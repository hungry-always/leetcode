package everyWeek.fight20Day.week182;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution1394 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(entry.getKey())) {
                result = entry.getKey();
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
    }
}
