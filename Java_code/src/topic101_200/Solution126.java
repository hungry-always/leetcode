package topic101_200;

import org.junit.jupiter.api.Test;
import java.util.*;

public class Solution126 {
    Map<String, Set<String>> map = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        for (String s : wordList) {
            addWordToMap(s);
        }
        addWordToMap(beginWord);
        addWordToMap(endWord);
        Set<String> keySet = new HashSet<>(map.keySet());
        keySet.remove(beginWord);
        Set<String> set = map.get(beginWord);
        
        return null;
    }

    private void addWordToMap(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, '*');
            String s1 = sb.toString();
            addStrToMap(s, s1);
            addStrToMap(s1, s);
            sb.setCharAt(i, c);
        }
    }

    private void addStrToMap(String key, String value) {
        Set<String> set = map.getOrDefault(key, new HashSet<>());
        set.add(value);
        map.put(key, set);
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        ArrayList<String> list1 = new ArrayList<>(list);
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> ladders = findLadders(beginWord, endWord, list1);
        System.out.println(ladders);
    }
}
