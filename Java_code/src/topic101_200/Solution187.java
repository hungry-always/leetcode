package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 发现重复字符串
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String substring = s.substring(i, i + 10);
            System.out.println(substring);
            if (set.contains(substring)) {
                result.add(substring);
            } else {
                set.add(substring);
            }
        }
        return new LinkedList<>(result);
    }

    @Test
    public void test() {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println("abcdcdefghi".substring(0,10));
    }
}
