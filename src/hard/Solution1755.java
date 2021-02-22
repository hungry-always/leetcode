package hard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution1755 {
    public int minAbsDifference(int[] nums, int goal) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        set1.add(0);
        set2.add(0);
        for (int i = 0; i < nums.length / 2; i++) {
            temp.clear();
            for (Integer num : set1) {
                temp.add(num + nums[i]);
            }
            set1.addAll(temp);
        }
        for (int i = nums.length / 2; i < nums.length; i++) {
            temp.clear();
            for (Integer num : set2) {
                temp.add(num + nums[i]);
            }
            set2.addAll(temp);
        }
        int[] ints1 = set1.stream().mapToInt(Integer::valueOf).sorted().toArray();
        int[] sum = set2.stream().mapToInt(Integer::valueOf).sorted().toArray();
        int length = sum.length;
        for (int i : ints1) {
            int j = goal - i;
            if (j <= sum[0]) {
                min = Math.min(min, sum[0] - j);
            } else if (j >= sum[length - 1]) {
                min = Math.min(min,j- sum[length - 1]);
            } else {
                int start = 0, end = length - 1;
                while (start <= end) {
                    if (start + 1 == end) {
                        min = Math.min(min, j - sum[start]);
                        min = Math.min(min, sum[end] - j);
                        break;
                    }
                    int mid = (start + end) / 2;
                    if (sum[mid] == j) {
                        return 0;
                    } else if (sum[mid] > j) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
            }
        }
        for (int i : ints1) {
            min = Math.min(min, Math.abs(goal - i));
        }
        for (int i : sum) {
            min = Math.min(min, Math.abs(goal - i));
        }
        return min;
    }

    @Test
    public void test() {
        int[] ints = {1,2,3};
        int i = minAbsDifference(ints, -7);
        System.out.println(i);
    }
}
