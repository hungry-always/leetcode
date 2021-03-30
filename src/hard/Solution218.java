package hard;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> lists = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        PriorityQueue<Integer> numberQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] building : buildings) {
            numberQueue.add(building[0]);
            numberQueue.add(building[0] + 1);
        }
        int bIndex = 0;
        int n = buildings.length;
        int index = buildings[0][0];
        queue.add(buildings[0]);
        int beforeValue = -1;
        while (!queue.isEmpty() || bIndex <= n - 1) {
            while (bIndex <= n - 1 && buildings[bIndex][0] == index) {
                queue.add(buildings[bIndex]);
                bIndex++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < index) {
                queue.poll();
            }
            int nowValue = queue.isEmpty() ? 0 : queue.peek()[2];
            if (nowValue < beforeValue) {
                List<Integer> list = new ArrayList<>(2);
                list.add(index - 1);
                list.add(nowValue);
                lists.add(list);
            } else if (nowValue > beforeValue) {
                List<Integer> list = new ArrayList<>(2);
                list.add(index);
                list.add(nowValue);
                lists.add(list);
            }
            beforeValue = nowValue;
            index++;
        }
        return lists;
    }

    @Test
    public void test() {
//        int[][] arr = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] arr = {{0, 2147483647, 2147483647}};
        List<List<Integer>> skyline = getSkyline(arr);
        System.out.println(skyline);
    }
}
