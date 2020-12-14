package everyWeek.s1;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    break;
                }
                if (i == word.length()-1) {
                    count++;
                }
            }
        }
        return count;
    }
}
