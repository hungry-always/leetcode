package everyWeek.s10;

public class Solution2 {
    public int maxAbsoluteSum(int[] nums) {
        int a1 = 0;
        int a2 = 0;
        int result = 0;
        for (int num : nums) {
            a1 += num;
            a2 += num;
            if (a1 > 0) {
                a1 = 0;
            }
            if (a2 <0) {
                a2 = 0;
            }
            result = Math.max(Math.max(Math.abs(a1), Math.abs(a2)), result);
        }
        return result;
    }
}
