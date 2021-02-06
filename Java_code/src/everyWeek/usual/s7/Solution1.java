package everyWeek.usual.s7;

import org.junit.jupiter.api.Test;

public class Solution1 {
    public int totalMoney(int n) {
        int result = 0;
        int i = n / 7;
        result += (49 + 7 * i) * i / 2;
        int j = n % 7;
        result += (2*i + j + 1) * j / 2;
        return result;
    }

    @Test
    public void test() {
        System.out.println(totalMoney(20));
    }
}
