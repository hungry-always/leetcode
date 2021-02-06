package everyDay;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution2_3 {
    Map<Integer, Integer> countMap1;
    Map<Integer, Integer> countMap2;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return Arrays.stream(nums).mapToDouble(Double::valueOf).toArray();
        }
        PriorityQueue<Integer> bigQue = new PriorityQueue<>();
        PriorityQueue<Integer> smallQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        countMap1 = new HashMap<>();
        countMap2 = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if (smallQue.size() < (k + 1) / 2) {
                smallQue.add(nums[i]);
            } else {
                if (nums[i] < smallQue.peek()) {
                    smallQue.add(nums[i]);
                    bigQue.add(smallQue.poll());
                } else {
                    bigQue.add(nums[i]);
                }
            }
        }
        List<Double> list = new LinkedList<>();
        int index = k - 1;
        while (true) {
            double fromQue = getFromQue(smallQue,countMap2);
            double fromQue1 = getFromQue(bigQue,countMap1);
            double e = (k % 2 != 0) ? fromQue : (fromQue + fromQue1) / 2.0;
            list.add(e);
            if (++index < nums.length) {
                int insertNum = nums[index];
                int deleteNum = nums[index - k];
                Integer fromQue2 = getFromQue(bigQue,countMap1);
                if (insertNum >= fromQue2 && deleteNum >= fromQue2) {
                    countMap1.put(deleteNum, countMap1.getOrDefault(deleteNum, 0) + 1);
                    bigQue.add(insertNum);
                } else if (insertNum >= fromQue2 && deleteNum < fromQue2) {
                    countMap2.put(deleteNum, countMap2.getOrDefault(deleteNum, 0) + 1);
                    bigQue.add(insertNum);
                    smallQue.add(fromQue2);
                    bigQue.poll();
                } else if (insertNum < fromQue2 && deleteNum >= fromQue2) {
                    countMap1.put(deleteNum, countMap1.getOrDefault(deleteNum, 0) + 1);
                    getFromQue(bigQue,countMap1);
                    smallQue.add(insertNum);
                    bigQue.add(getFromQue(smallQue,countMap1));
                    smallQue.poll();
                } else {
                    countMap2.put(deleteNum, countMap2.getOrDefault(deleteNum, 0) + 1);
                    smallQue.add(insertNum);
                }
            } else {
                break;
            }
        }
        return list.stream().mapToDouble(Double::valueOf).toArray();
    }

    private Integer getFromQue(PriorityQueue<Integer> smallQue,Map<Integer,Integer> countMap) {
        while (true) {
            Integer peek = smallQue.peek();
            Integer count = countMap.get(peek);
            if (count == null) {
                return peek;
            } else {
                smallQue.poll();
                if (count == 1) {
                    countMap.remove(peek);
                } else {
                    countMap.put(peek, count - 1);
                }
            }
        }
    }

    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(-1));
    }
}
