package match.s195;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        int[] countArr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int key = i % k;
            if(key<0){
                key+=k;
            }
            countArr[key]++;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (countArr[i] != countArr[k - i]) {
                return false;
            }
        }
        if (k % 2 == 0 && countArr[k / 2] % 2 != 0) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        boolean b = canArrange(new int[]{3, 8, 7, 2}, 10);
        System.out.println(b);
    }
}
