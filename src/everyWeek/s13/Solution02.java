package everyWeek.s13;

import org.junit.jupiter.api.Test;

public class Solution02 {
    public int[] minOperations(String boxes) {
        int[] ints = new int[boxes.length()];
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                count += i;
                right++;
            }
        }
        for (int i = 0; i < boxes.length(); i++) {
            ints[i] = count;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            count += (left - right);
        }
        return ints;
    }

    @Test
    public void test() {
        int[] ints = minOperations("001011");
        System.out.println(ints);
    }
}
