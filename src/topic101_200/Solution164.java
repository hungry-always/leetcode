package topic101_200;

public class Solution164 {
    // 桶排序
    public int maximumGap(int[] nums) {
        if (nums == nums || nums.length <= 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return 1;
    }
}
