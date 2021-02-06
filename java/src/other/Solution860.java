package other;

import org.junit.jupiter.api.Test;

public class Solution860 {
    int[] nums = new int[4];
    public boolean lemonadeChange(int[] bills) {
        for (int bill : bills) {
            if (!addBill(bill)) {
                return false;
            }
        }
        return true;
    }

    private boolean addBill(int bill) {
        switch (bill) {
            case 50:
                nums[0]++;
                break;
            case 20:
                nums[1]++;
                break;
            case 10:
                nums[2]++;
                break;
            case 5:
                nums[3]++;
                break;
        }
        bill -= 5;
        switch (bill) {
            case 95:
                int min1 = Math.min(bill / 50, nums[0]);
                bill -= (50 * min1);
                nums[0] -= min1;
            case 45:
                int min2 = Math.min(bill / 20, nums[1]);
                bill -= (20 * min2);
                nums[1] -= min2;
            case 15:
                int min3 = Math.min(bill / 10, nums[2]);
                bill -= (10 * min3);
                nums[2] -= min3;
            case 5:
                int min4 = Math.min(bill / 5, nums[3]);
                bill -= (5 * min4);
                nums[3] -= min4;
        }
        return bill == 0;
    }

    @Test
    public void test() {
        int[] nums = {10,10};
        System.out.println(lemonadeChange(nums));
    }
}
