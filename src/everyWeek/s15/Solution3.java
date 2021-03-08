package everyWeek.s15;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution3 {
    public int beautySum(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Set<Character>> map = new HashMap<>();
            int[] count = new int[26];
            int min = 1, max = 1;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                int index = c - 'a';
                count[index]++;
                Set<Character> orDefault = map.getOrDefault(count[index], new HashSet<>());
                orDefault.add(c);
                map.put(count[index], orDefault);
                if (map.get(count[index] - 1) != null) {
                    map.get(count[index] - 1).remove(c);
                }
                if (map.get(max + 1) != null && !map.get(max + 1).isEmpty()) {
                    max++;
                }
                if (map.get(1) != null && map.get(1).size()!=0) {
                    min = 1;
                } else {
                    if (map.get(min) == null || map.get(min).isEmpty()) {
                        min++;
                    }
                }
                result += (max - min);
            }
        }
        return result;
    }

    @Test
    public void test() {
        String s = "aabcbaa";
        int i = beautySum(s);
        System.out.println(i);
    }
}
