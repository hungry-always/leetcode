package topic0_100;

import org.junit.jupiter.api.Test;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int firstTarget = getFirstTarget(nums, target);
        int lastTarget = getLastTarget(nums, target);
        if (firstTarget == -1 || lastTarget == -1) {
            return new int[]{-1, -1};
        }
        firstTarget = (nums[firstTarget] == target) ? firstTarget : firstTarget + 1;
        lastTarget = (nums[lastTarget] == target) ? lastTarget : lastTarget - 1;
        if (lastTarget < firstTarget) {
            return new int[]{-1, -1};
        } else {
            return new int[]{firstTarget, lastTarget};
        }
    }

    int getLastTarget(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[end] < target) {
            return -1;
        }
        while (start < end) {
            int mid = (start + end) / 2;
            int num = nums[mid];
            if (num > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
    int getFirstTarget(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] > target) {
            return -1;
        }
        while (start < end) {
            int mid = (start + end) / 2;
            int num = nums[mid];
            if (num >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    @Test
    public void test() {

        int[] ints = {2,2};
        int[] x = searchRange(ints, 2);
        System.out.println(x);
        System.out.println(1);
    }
}
