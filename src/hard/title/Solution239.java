package hard.title;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 滑动窗口最大值
 */
public class Solution239 {
    /**
     * 优先队列方法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        int[] maxArr = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        maxArr[0] = queue.peek();
        for (int i = k; i < n; i++) {
            int num = nums[i - k];
            // 存放已经删除的数字
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            // 清理已经删除的数字
            cleanUpRedundantNumber(countMap, queue);
            queue.add(nums[i]);
            maxArr[i - k + 1] = queue.peek();
        }
        return maxArr;
    }

    private void cleanUpRedundantNumber(Map<Integer, Integer> countMap, PriorityQueue<Integer> queue) {
        while (!queue.isEmpty() && countMap.containsKey(queue.peek())) {
            Integer poll = queue.poll();
            countMap.put(poll, countMap.get(poll) - 1);
            if (countMap.get(poll) == 0) {
                countMap.remove(poll);
            }
        }
    }

    /**
     * 最小栈
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] maxArr = new int[n - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            addQueue(queue, nums, i, 0);
        }
        for (int i = 0; i < maxArr.length; i++) {
            addQueue(queue, nums, i + k - 1, i);
            maxArr[i] = nums[queue.peek()];
        }
        return maxArr;
    }

    private void addQueue(Deque<Integer> queue, int[] nums, int index, int start) {
        while (!queue.isEmpty() && nums[queue.getLast()] <= nums[index]) {
            queue.removeLast();
        }
        while (!queue.isEmpty() && queue.getFirst() < start) {
            queue.removeFirst();
        }
        queue.add(index);
    }


    @Test
    public void test() {
        int[] ints = maxSlidingWindow(new int[]{
                7,2,4,1}, 4);
        System.out.println(ints);
    }
}
