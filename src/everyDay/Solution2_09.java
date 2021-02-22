package everyDay;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution2_09 {
    // TODO
    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        boolean flag = false;
        boolean isMore = false;
        int start = -1;
        int count = 0;
        while (right < n || left < n) {
            if (!isMore) {
                while (right < n) {
                    int num = A[right];
                    if (!isMore || map.keySet().contains(num)) {
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        if (!isMore && map.size() == K) {
                            isMore = true;
                            start = right;
                        }
                        right++;
                    } else {
                        break;
                    }
                }
                if (right >= n) {
                    break;
                }
            } else {
                while (true) {
                    count += (right - start);
                    int num = A[left];
                    left++;
                    map.put(num, map.get(num) - 1);
                    if (map.get(num) == 0) {
                        map.remove(num);
                        isMore = false;
                        break;
                    }
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        int i = subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3);
        System.out.println(i);
    }
}
