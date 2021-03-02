package topic0_100;

/**
 * 搜索旋转排序数组
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return (target == nums[0]) ? 0 : -1;
        }
        int startNum = nums[0];
        int start = 0, end = n - 1;
        while (end >= start) {
            int mid = (end + start) / 2;
            int num = nums[mid];
            if (nums[mid] == target) {
                return mid;
            } else if (target >= startNum) {
                if (num > target||num<startNum) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if (num < target || num >= startNum) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
