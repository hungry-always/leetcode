package topic101_200;

import org.junit.jupiter.api.Test;

public class Solution190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (i != 0) {
                result <<= 1;
            }
            result += (1 & n);
            n >>= 1;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(reverseBits(43261596));
    }
}
