package everyWeek.s232;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                count++;
            }
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }
        for (Character c : map1.keySet()) {
            if (map2.get(c) == null || map1.get(c) != map2.get(c)) {
                return false;
            }
        }
        if (count > 2) {
            return false;
        }
        return true;
    }
}
