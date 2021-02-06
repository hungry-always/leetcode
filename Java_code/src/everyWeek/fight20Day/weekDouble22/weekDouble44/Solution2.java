package everyWeek.fight20Day.weekDouble22.weekDouble44;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution2 {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int i = 1; i <= n+1; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < languages.length; i++) {
            Set<Integer> set = map.get(i + 1);
            for (int j : languages[i]) {
                set.add(j);
            }
//            map.put(i + 1, set);
        }
        List<int[]> list = new LinkedList<>();
        for (int[] friendship : friendships) {
            boolean flag = false;
            Set<Integer> set1 = map.get(friendship[0]);
            Set<Integer> set2 = map.get(friendship[1]);
            for (Integer ind : set1) {
                if (set2.contains(ind)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(friendship);
            }
        }
        return minimumTeachings(list, map, 0,0);
    }

    private int minimumTeachings(List<int[]> list, Map<Integer, Set<Integer>> map, int index,int count) {
        if (index >= list.size()) {
            return count;
        }
        int[] nums = list.get(index);
        int num1 = nums[0];
        Set<Integer> set1 = map.get(num1);
        int num2 = nums[1];
        Set<Integer> set2 = map.get(num2);
        int result = -1;
        if (set1.contains(num2) || set2.contains(num1)) {
            result = minimumTeachings(list, map, index + 1, count);
        } else {
            for (Integer ind : set1) {
                set2.add(ind);
                int i = minimumTeachings(list, map, index + 1, count + 1);
                result = (result == -1) ? i : Math.min(i, result);
                set2.remove(ind);
            }
            for (Integer ind : set2) {
                set1.add(ind);
                int i = minimumTeachings(list, map, index + 1, count + 1);
                result = (result == -1) ? i : Math.min(i, result);
                set1.remove(ind);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int i = minimumTeachings(2, new int[][]{{1}, {2}, {1, 2}}, new int[][]{{1, 2}, {1, 3}, {2, 3}});
        System.out.println(i);
    }
}
