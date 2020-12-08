package topic101_200;

import org.junit.jupiter.api.Test;

/**
 * 位1的个数
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(-3));
    }
}
