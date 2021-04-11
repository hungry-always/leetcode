package match.d29;

public class Solution1493 {
    public int longestSubarray(int[] nums) {
        boolean flag = false;
        int start1 = 0;
        int start2 = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                if (flag) {
                    start1 = start2 + 1;
                } else {
                    flag = true;
                }
                start2 = i;
            }
            int length = i - start1 + 1;
            if (flag) {
                length--;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
