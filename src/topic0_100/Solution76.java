package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution76 {
    HashMap<Character, Integer> map = new HashMap<>();
    HashMap<Character, Integer> countMap = new HashMap<>();
    HashSet<Character> set;
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        set = new HashSet<>();
        int left = 0, right = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            putCharToMap(c, 1);
            while (set.size() == map.size()) {
                if (right - left < end - start) {
                    end = right;
                    start = left;
                }
                putCharToMap(s.charAt(left), -1);
                left++;
            }
            right++;
        }
        return (end == Integer.MAX_VALUE) ? "" : s.substring(start, end+1);
    }
    private void putCharToMap(char c,int count) {
        countMap.put(c, countMap.getOrDefault(c, 0) + count);
        if (map.get(c) != null && countMap.get(c)!=null&&countMap.get(c)>=map.get(c)) {
            set.add(c);
        } else {
            set.remove(c);
        }
    }

    @Test
    public void test() {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
