package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        List<Integer> list = new LinkedList<>();
        int length = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            int sLength = s.length();
            if (i + length * wordLength > sLength) {
                break;
            }
            HashMap<String, Integer> doMap = new HashMap<>(map);
            int startI = i;
            for (int j = 0; j < length; j++) {
                String substring = s.substring(i + j * wordLength, i + wordLength + j * wordLength);
                removeKey(substring, doMap);
            }
            while (startI + wordLength * length <= sLength) {
                if (startI != i) {
                    String before = s.substring(startI - wordLength, startI);
                    addKey(before, doMap);
                    String last = s.substring(startI + wordLength * length - wordLength, startI + wordLength * length);
                    removeKey(last, doMap);
                }
                if (doMap.size() == 0) {
                    list.add(startI);
                }
                startI += wordLength;
            }
        }
        return list;
    }

    private void removeKey(String key, Map<String, Integer> map) {
        Integer count = map.getOrDefault(key, 0);
        count--;
        if (count == 0) {
            map.remove(key);
        } else {
            map.put(key, count);
        }
    }
    private void addKey(String key, Map<String, Integer> map) {
        Integer count = map.getOrDefault(key, 0);
        count++;
        if (count == 0) {
            map.remove(key);
        } else {
            map.put(key, count);
        }
    }

    @Test
    public void test() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo","the"};
        System.out.println(findSubstring(s,words));
    }
}
