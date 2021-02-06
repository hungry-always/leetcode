package everyWeek.fight20Day.week183;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        a = nums[0];
        b = nums[1];
        c = nums[2];
        int aCount = a;
        int bCount = b;
        int cCount = c;
        StringBuilder sb = new StringBuilder();
        while (bCount >= 1) {
            if (cCount > bCount) {
                sb.append(c);
                cCount--;
            }
            sb.append(c).append(b);
            cCount--;
            bCount--;
        }
        while (cCount >= 1 && bCount >= 1) {
            if (cCount > aCount) {
                sb.append(c);
                cCount--;
            }
            sb.append(c).append(a);
            aCount--;
            cCount--;
        }
        if (aCount > 0) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'b' && sb.charAt(i + 1) != 'b') {
                    if (aCount >= 2) {
                        sb.insert(i, a);
                        sb.insert(i, a);
                        i += 2;
                        aCount -= 2;
                    } else if (aCount == 1) {
                        aCount--;
                        sb.insert(i, a);
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(longestDiverseString(1, 1, 7));
    }
}
