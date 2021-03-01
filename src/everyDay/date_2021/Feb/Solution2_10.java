package everyDay.date_2021.Feb;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution2_10 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            putCharToMap(c, map, 1);
            if (i >= length) {
                putCharToMap(s2.charAt(i - length), map, -1);
            }
            if (map.size() == 0) {
                return true;
            }
        }
        return false;
    }

    private void putCharToMap(char c, Map<Character, Integer> map, int count) {
        map.put(c, map.getOrDefault(c, 0) + count);
        if (map.get(c) == 0) {
            map.remove(c);
        }
    }

    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));
    }
}
