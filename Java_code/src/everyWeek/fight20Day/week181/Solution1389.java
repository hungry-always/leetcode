package everyWeek.fight20Day.week181;

import org.junit.jupiter.api.Test;

public class Solution1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        boolean[] checkArr = new boolean[length];
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int ind = index[i];
            int num = nums[i];
            for (int j = ind; j < length; j++) {
                if (checkArr[j]) {
                    int temp = result[j];
                    result[j] = num;
                    num = temp;
                } else {
                    checkArr[j] = true;
                    result[j] = num;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] targetArray = createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
        System.out.println(targetArray);
    }
}
