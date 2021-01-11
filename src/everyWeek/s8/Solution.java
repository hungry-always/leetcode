package everyWeek.s8;

import org.junit.jupiter.api.Test;

public class Solution {
    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int[] result = new int[length + 1];
        result[0] = first;
        for (int i = 1; i <= length; i++) {
            int i1 = encoded[i - 1] | first;
            if (first < encoded[i - 1]) {
                result[i] = i1;
            } else {
                result[i] = i1 - first;
            }
            first = result[i];
        }
        return result;
    }

    @Test
    public void test() {
        int[] decode = decode(new int[]{6,2,7,3}, 4);
        System.out.println(decode);
    }
}
