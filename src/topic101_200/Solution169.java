package topic101_200;

public class Solution169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int countNum = nums[0];
        for (int num : nums) {
            if (num == countNum) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                countNum = num;
                count = 1;
            }
        }
        return -1;
    }
}
