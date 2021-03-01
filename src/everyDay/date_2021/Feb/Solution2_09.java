package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * K个不同整数子数组
 */
// TODO
public class Solution2_09 {
    boolean flag = false;
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int n = A.length;
        int left1 = 0, left2 = 0, right = 0;
        while (right + 1 < n && !(map1.size() == K && !map1.keySet().contains(A[right + 1]))) {
            right++;
            int num = A[right];
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        return 0;
    }

    @Test
    public void test() {
        int i = subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3);
        System.out.println(i);
    }
}
