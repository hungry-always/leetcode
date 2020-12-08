package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int positive = 1, negative = 1;
        boolean isNegative = false;
        int max = nums[0];
        for (int num : nums) {
            if (num > 0) {
                positive *= num;
                if (isNegative) {
                    negative *= num;
                }
                max = Math.max(max, positive);
            } else if (num == 0) {
                positive = 0;
                isNegative = false;
                max = Math.max(max, positive);
            } else {
                if (isNegative) {
                    int temp = positive;
                    positive = negative * num;
                    negative = temp * num;
                    max = Math.max(max, positive);
                } else {
                    negative = positive * num;
                    positive = 1;
                    isNegative = true;
                }
            }
            if (num == 0) {
                positive = 1;
            }
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
}
