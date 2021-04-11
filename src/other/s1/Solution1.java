package other.s1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1{
    Map<String, Integer> map = new HashMap<>();
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] countArr = new int[batchSize];
        int remainCount = 0;
        for (int group : groups) {
            countArr[group % batchSize]++;
            if (group % batchSize != 0) {
                remainCount++;
            }
        }
        return countArr[0] + dfs(0, countArr, remainCount);
    }

    private int dfs(int remainValue, int[] countArr, int remainCount) {
        if (remainCount == 0) {
            return 0;
        }
        String key = Arrays.toString(countArr) + remainValue;
        int batchSize = countArr.length;
        if (map.get(key) != null) {
            return map.get(key);
        }
        int result = 0;
        if (remainValue == 0) {
            result++;
        } else if (remainValue < 0) {
            remainValue += batchSize;
        }
        for (int i = 1; i < batchSize; i++) {
            if (countArr[i] != 0) {
                countArr[i]--;
                int dfs = dfs(remainValue - i, countArr, remainCount - 1);
                countArr[i]++;
                if (remainValue == i) {
                    return dfs + 1;
                } else {
                    result = Math.max(dfs, result);
                }
            }
        }
        map.put(key, result);
        return result;
    }

    @Test
    public void test() {
        int i = maxHappyGroups(3, new int[]{844438225,657615828,355556135,491931377,644089602,30037905,863899906,246536524,682224520});
        System.out.println(i);
    }
}