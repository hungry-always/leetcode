package everyDay;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2_01 {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(B);
        int dis = (Arrays.stream(A).sum() - Arrays.stream(B).sum())/2;
        Set<Integer> set = new HashSet<>();
        for (int i : B) {
            set.add(i);
        }
        for (int i : A) {
            if (set.contains(i-dis)) {
                return new int[]{i, i-dis};
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] ints = fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
        System.out.println(ints);
    }
}
