package everyDay;

public class Solution2_05 {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int result = 0;
        int cost = 0;
        int left = 0, right = 0;
        while (right <= length - 1) {
            if (cost > maxCost) {
                cost -= nums[left];
                left++;
            } else {
                cost += nums[right];
                right++;
            }
            if (cost <= maxCost) {
                result = Math.max(result, right - left);
            }
        }
        return result;
    }
}
