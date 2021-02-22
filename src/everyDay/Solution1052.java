package everyDay;

import org.junit.jupiter.api.Test;

public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int num = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                num += customers[i];
            }
        }
        int max = num;
        for (int i = X; i < grumpy.length; i++) {
            num += (grumpy[i] * customers[i] - grumpy[i - X] * customers[i - X]);
            max = Math.max(max, num);
        }
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        return sum + max;
    }

    @Test
    public void test() {
        int i = maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
        System.out.println(i);
    }
}
