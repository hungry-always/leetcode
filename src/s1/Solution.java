package s1;

import cn.hutool.log.Log;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    long start = 1;

    public int orchestraLayout(int num, int xPos, int yPos) {
        int start1 = 0;
        int start2 = 0;
        int end1 = num - 1;
        int end2 = num - 1;
        while (start1 != xPos && start2 != xPos && end1 != yPos && end2 != yPos) {
            start += (long) (end1 - start1) * 4;
            start %= 9;
            start1++;
            end1--;
            start2++;
            end2--;
        }
        if (xPos != start2) {
            start += (end1 - start1 + 1);
        } else {
            start += (yPos - start1);
            return getNumber();
        }
        start2++;
        if (yPos != end1) {
            start += (end2 - start2 + 1);
        } else {
            start += (xPos - start2);
            return getNumber();
        }
        end1--;
        if (xPos != end2) {
            start += (end1 - start1 + 1);
        } else {
            start += (end1 - yPos);
            return getNumber();
        }
        end2--;
        start += (end1 - xPos);
        return getNumber();
    }

    private int getNumber() {
        long i = start % 9;
        start %= 9;
        return (int) ((i == 0) ? 9 : i);
    }

    @Test
    public void test() {
        int num = (int) 4;
        int i = orchestraLayout(num, 2, 3);
        System.out.println(i);
    }
}
