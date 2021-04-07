package match.s195;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1496 {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int[] nums = new int[2];
        set.add(Arrays.toString(nums));
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    nums[0]++;
                    break;
                case 'S':
                    nums[0]--;
                    break;
                case 'E':
                    nums[1]++;
                    break;
                case 'W':
                    nums[1]--;
                    break;
            }
            String s = Arrays.toString(nums);
            if (set.contains(s)) {
                return true;
            }
            set.add(s);
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(new int[2]));
    }
}
