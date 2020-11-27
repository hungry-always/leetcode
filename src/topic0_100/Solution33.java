package topic0_100;

public class Solution33 {
    public int search(int[] nums, int target) {
        int index = -1;
        boolean less = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (less) {
                    return -1;
                }
                less = true;
                index = i - 1;
            }
        }
        if (!less) {
            return -1;
        }
        return index;
    }
}
