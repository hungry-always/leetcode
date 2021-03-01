package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

/**
 * 最长湍流子数组
 */
public class Solution2_08 {
    public int maxTurbulenceSize(int[] arr) {
        int count = 1, max = 1, status = Status.equal.status;
        for (int i = 1; i < arr.length; i++) {
            int nowStatus = Status.getStatus(arr[i], arr[i - 1]);
            if (nowStatus != 0) {
                if (status + nowStatus == Status.equal.status) {
                    count++;
                } else {
                    count = 2;
                }
            }
            status = nowStatus;
            max = Math.max(max, count);
        }
        return max;
    }
    enum Status{
        more(1),
        less(-1),
        equal(0);
        int status;

        Status(int status) {
            this.status = status;
        }

        public static int getStatus(int number1, int number2) {
            if (number1 == number2) {
                return equal.status;
            } else if (number1 > number2) {
                return more.status;
            } else {
                return less.status;
            }
        }
    }

    @Test
    public void test() {
        int i = maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        System.out.println(i);
        System.out.println(maxTurbulenceSize(new int[]{4, 8, 12, 15}));
    }
}
