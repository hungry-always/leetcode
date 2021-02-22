package everyWeek.s13;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

public class Solution03 {
    HashMap<Sign, Integer> map = new HashMap<>();

    public int maximumScore(int[] nums, int[] multipliers) {
        int start1 = 0, end1 = nums.length - 1;
        return maximumScore(nums, multipliers, start1, end1, 0);
    }

    private int maximumScore(int[] nums, int[] multipliers, int start1, int end1, int m) {
        Sign sign = new Sign(start1, end1, m);
        if (map.get(sign) != null) {
            return map.get(sign);
        }
        if (m >= multipliers.length) {
            return 0;
        }
        int mu = multipliers[m];
        int i1 = maximumScore(nums, multipliers, start1 + 1, end1, m + 1);
        int i = i1 + nums[start1] * mu;
        int i2 = maximumScore(nums, multipliers, start1, end1 - 1, m + 1);
        int j = i2 + nums[end1] * mu;
        int max = Math.max(i, j);
        map.put(sign, max);
        return max;
    }

    class Sign {
        int start;
        int end;
        int m;

        public Sign(int start, int end, int m) {
            this.start = start;
            this.end = end;
            this.m = m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Sign)) {
                return false;
            }
            Sign sign = (Sign) o;
            return start == sign.start && end == sign.end && m == sign.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, m);
        }
    }

    @Test
    public void test() {
        int[] nums1 = {-5, -3, -3, -2, 7, 1};
        int[] multipliers1 = {-10, -5, 3, 4, 6};
        int i = maximumScore(nums1, multipliers1);
        System.out.println(i);
    }
}
