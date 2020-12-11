//package topic101_200;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//
//public class Solution126 {
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> lists = new LinkedList<>();
//        Map<String, Map<String, List<String>>> map = new HashMap<>();
//        wordList.add(beginWord);
//        for (int i = 0; i < wordList.size(); i++) {
//            String s1 = wordList.get(i);
//            for (int j = i + 1; j < wordList.size(); j++) {
//                String s2 = wordList.get(j);
//                if (checkReplace(s1, s2)) {
//                    Map<String, List<String>> mapOrDefault1 = map.getOrDefault(s1, new HashMap<>());
//                    Map<String, List<String>> mapOrDefault2 = map.getOrDefault(s2, new HashMap<>());
//                    mapOrDefault1.put(s2, new LinkedList<>());
//                    mapOrDefault2.put(s1, new LinkedList<>());
//                    map.put(s1, mapOrDefault1);
//                    map.put(s2, mapOrDefault2);
//                }
//            }
//        }
//        if (!map.containsKey(endWord)) {
//            return lists;
//        }
//        Map<String, List<String>> stringListMap = map.get(beginWord);
//        while (stringListMap != null) {
//            for (String s : stringListMap.keySet()) {
//                Map<String, List<String>> listMap = map.get(s);
//                for (String s1 : listMap.keySet()) {
//                    if (s1 == endWord) {
//                        lists.add(listMap.get(s1));
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    private boolean checkReplace(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        int count = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                if (count == 0) {
//                    count++;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    @Test
//    public void test() {
//        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
//        ArrayList<String> list1 = new ArrayList<>(list);
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<List<String>> ladders = findLadders(beginWord, endWord, list1);
//        System.out.println(ladders);
//    }
//}
