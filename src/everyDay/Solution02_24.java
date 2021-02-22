package everyDay;

import commmon.ArraysUtils;
import org.junit.jupiter.api.Test;

/**
 * 832 翻转图像
 */
public class Solution02_24 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] nums : A) {
            for (int i = 0; i < nums.length / 2; i++) {
                int num = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1-i] = num;
            }
        }
        for (int[] nums : A) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] ^= 1;
            }
        }
        return A;
    }

    @Test
    public void test() {
        String s = "[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]";
        int[][] a = ArraysUtils.generateTwo(s);
        int[][] ints = flipAndInvertImage(a);
        System.out.println("");
    }
}
