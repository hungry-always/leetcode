package everyDay;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution2_13 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            num = (num - 1) % n;
            nums[num] += n;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }

    @Test
    public void test() {
        List<Integer> disappearedNumbers = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers);
    }
}
