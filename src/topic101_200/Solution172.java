package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += (n /= 5);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(trailingZeroes(5));
    }
}
