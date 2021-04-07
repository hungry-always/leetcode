package lccup;

import org.junit.jupiter.api.Test;

class Solution1 {
    long start = 1;

    public int orchestraLayout(int num, int xPos, int yPos) {
        long min = Math.min(Math.min(xPos, yPos), Math.min(num - xPos - 1, num - yPos - 1));
        long i = (num - min) * (min % 9);
        long start1 = min;
        long start2 = min;
        long end1 = num - min - 1;
        long end2 = num - min - 1;
        start += 4L * i;
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
        int i = orchestraLayout(74644444, 7084, 2520);
//        int i = orchestraLayout(4, 1, 2);
        System.out.println(i);
    }
}
