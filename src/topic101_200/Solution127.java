package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution127 {
    Map<String, HashSet<String>> map = new HashMap<>();
    Map<String, Integer> countMap = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addToMap(word);
        }
        addToMap(beginWord);
        countMap.remove(beginWord);
        Set<String> strings = map.get(beginWord);
        while (!strings.isEmpty()) {
            if (strings.contains(endWord)) {
                return countMap.get(endWord) + 1;
            }
            Set<String> temp = new HashSet<>();
            for (String string : strings) {
                if (countMap.containsKey(string)) {
                    Integer count = countMap.get(string);
                    for (String s : map.get(string)) {
                        if (countMap.containsKey(s)) {
                            countMap.put(s, (s.contains("*")) ? count : count + 1);
                            temp.add(s);
                        }
                    }
                }
                countMap.remove(string);
            }
            if (temp.isEmpty()) {
                break;
            }
            strings = temp;
        }
        return 0;
    }

    private void addToMap(String word) {
        map.put(word, new HashSet<>());
        countMap.put(word, 0);
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, '*');
            if (map.get(sb.toString()) == null) {
                countMap.put(sb.toString(), 0);
                map.put(sb.toString(), new HashSet<>());
            }
            map.get(sb.toString()).add(word);
            map.get(word).add(sb.toString());
            sb.setCharAt(i, temp);
        }
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        ArrayList<String> list1 = new ArrayList<>(list);
        String beginWord = "hit";
        String endWord = "cog";
        int i = ladderLength(beginWord, endWord, list1);
        System.out.println(i);
        System.out.println(map);
        System.out.println(countMap);
    }
}
