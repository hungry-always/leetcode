package everyDay;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution2_21 {
    public int longestSubarray(int[] nums, int limit) {
        int count = 1;
        Queue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
        queue1.add(nums[0]);
        queue2.add(nums[0]);
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            int less = getInt(queue1, map1);
            int more = getInt(queue2, map2);
            if (Math.abs(more - less) <= limit) {
                count = Math.max(count, right - left + 1);
                if (++right < nums.length) {
                    queue1.add(nums[right]);
                    queue2.add(nums[right]);
                }
            } else {
                int num = nums[left];
                map1.put(num, map1.getOrDefault(num, 0) + 1);
                map2.put(num, map2.getOrDefault(num, 0) + 1);
                left++;
            }
        }
        return count;
    }

    private int getInt(Queue<Integer> queue, Map<Integer, Integer> map) {
        while (true) {
            Integer peek = queue.peek();
            if (map.get(peek) != null && map.get(peek) != 0) {
                queue.poll();
                map.put(peek, map.get(peek) - 1);
                if (map.get(peek) == 0) {
                    map.remove(peek);
                }
            } else {
                return peek;
            }
        }
    }

    @Test
    public void test() {
        int i = longestSubarray(new int[]{8,2,4,7,1,23}, 45);
        System.out.println(i);
    }
}
