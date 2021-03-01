package everyDay.date_2021.Feb;

public class Solution2_28 {
    public boolean isMonotonic(int[] A) {
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                flag1 = false;
                break;
            }
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                flag2 = false;
                break;
            }
        }
        return flag1 || flag2;
    }
}
