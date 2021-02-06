package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution171 {
    public int titleToNumber(String s) {
        int count = 0;
        int product = 1;
        for (int i = s.length(); i > 0; i--) {
            int value = s.charAt(i - 1) - 64;
            count += (product * value);
            product *= 26;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(titleToNumber("ZY"));
    }
}
