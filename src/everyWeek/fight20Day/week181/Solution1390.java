package everyWeek.fight20Day.week181;

import org.junit.jupiter.api.Test;

public class Solution1390 {
    public int sumFourDivisors(int[] nums) {
        boolean flag = false;
        int sum = 0;
        for (int num : nums) {
            int fourDivisorsSum = findFourDivisors(num);
            if (fourDivisorsSum !=-1) {
                sum += fourDivisorsSum;
                flag = true;
            }
        }
        return flag ? sum : -1;
    }

    private int findFourDivisors(int num) {
        int n1 = 1;
        int n2 = num;
        int count = 0;
        int sum = 0;
        while (n1 <= n2) {
            if (num % n1 == 0) {
                n2 = num / n1;
                if (n1 == n2) {
                    count += 1;
                    sum += n1;
                } else {
                    count += 2;
                    sum += (n1 + n2);
                }
            }
            n1++;
            n2--;
            if (count > 4) {
                return -1;
            }
        }
        return (count == 4) ? sum : -1;
    }

    @Test
    public void test() {
        System.out.println(sumFourDivisors(new int[]{21, 4, 7}));
    }
}
