package everyDay;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2_03 {
    Map<Long, Integer> countMap1 = new HashMap<>();
    int count1;
    Map<Long, Integer> countMap2 = new HashMap<>();
    PriorityQueue<Long> queue2 = new PriorityQueue<>(Comparator.comparingLong(Long::valueOf));
    PriorityQueue<Long> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
    int n;

    public double[] medianSlidingWindow(int[] nums, int k) {
        n = nums.length;
        double[] resultArr = new double[n - k + 1];
        for (int i = 0; i < k; i++) {
            queue1.add((long)nums[i]);
        }
        while (queue1.size() > (k + 1) / 2) {
            queue2.add(queue1.poll());
        }
        count1 = (k + 1) / 2;
        final int size1 = count1;
        resultArr[0] = getMid(k);
        for (int i = k; i < n; i++) {
            long num = nums[i - k];
            if (num <= getInteger(queue1, countMap1)) {
                countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
                count1--;
            } else {
                countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
            }
            int num1 = nums[i];
            queue2.add((long)num1);
            if (count1 < size1) {
                getInteger(queue2, countMap2);
                queue1.add(queue2.poll());
                count1++;
            }
            Long i1 = getInteger(queue1, countMap1);
            Long i2 = getInteger(queue2, countMap2);
            if (i1 != null && i2 != null && i1 > i2) {
                queue2.add(queue1.poll());
                queue1.add(queue2.poll());
            }
            resultArr[i - k + 1] = getMid(k);
        }
        return resultArr;
    }

    private double getMid(int k) {
        if (k % 2 == 1) {
            return getInteger(queue1, countMap1);
        } else {
            double i = getInteger(queue1, countMap1) + (long)getInteger(queue2, countMap2);
            return i / 2.0;
        }
    }

    private Long getInteger(PriorityQueue<Long> queue, Map<Long, Integer> countMap) {
        while (true) {
            if (queue.isEmpty()) {
                return null;
            }
            Long peek = queue.peek();
            if (countMap.get(peek) == null || countMap.get(peek) == 0) {
                return peek;
            } else {
                countMap.put(peek, countMap.get(peek) - 1);
                queue.poll();
            }
        }
    }

    @Test
    public void test() {
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        double[] doubles = medianSlidingWindow(ints, 3);
        System.out.println(doubles);
    }
}
