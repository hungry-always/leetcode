package everyDay;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution187 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer orDefault = map.getOrDefault(c, 0);
            map.put(c, ++orDefault);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int leetcode = firstUniqChar("leetcode");
    }
}
