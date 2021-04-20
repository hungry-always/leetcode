package lcp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution02 {
    public int[] fraction(int[] cont) {
        if (cont.length == 1) {
            return new int[]{cont[0], 1};
        }
        int up = 1;
        int n = cont.length;
        int down = cont[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int num = cont[i];
            up += (down * num);
            if (i != 0) {
                int temp = up;
                up = down;
                down = temp;
            }
        }
        return new int[]{up, down};
    }

    @Test
    public void test() {
//        int[] fraction = fraction(new int[]{3, 2, 0, 2});
        int[] fraction = fraction(new int[]{0, 0, 3});
        System.out.println(Arrays.toString(fraction));
    }
}
