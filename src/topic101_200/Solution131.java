package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution131 {
    Map<String, List<List<String>>> map = new HashMap<>();
    Map<String, Boolean> palindromeMap = new HashMap<>();

    public List<List<String>> partition(String s) {
        return generateList(s);
    }

    private List<List<String>> generateList(String s) {
        if (map.get(s) != null) {
            return map.get(s);
        }
        List<List<String>> lists = new ArrayList<>();
        int length = s.length();
        if (length != 0) {
            if (isPalindrome(s)) {
                lists.add(Arrays.asList(s));
            }
            if (length >= 2) {
                for (int i = 1; i < length; i++) {
                    String substring = s.substring(0, i);
                    String substring1 = s.substring(i);
                    if (isPalindrome(substring1)) {
                        List<List<String>> list = generateList(substring);
                        for (List<String> strings : list) {
                            ArrayList<String> subList = new ArrayList<>(strings);
                            subList.add(substring1);
                            lists.add(subList);
                        }
                    }
                }
            }
        }
        map.put(s, lists);
        return lists;
    }

    private boolean isPalindrome(String s) {
        Boolean isPalindrome = palindromeMap.get(s);
        if (isPalindrome != null) {
            return isPalindrome;
        }
        boolean result;
        int length = s.length();
        if (length == 1) {
            result = true;
        } else if (length == 2) {
            result = (s.charAt(0) == s.charAt(1));
        } else {
            result = (s.charAt(0) == s.charAt(length - 1) && isPalindrome(s.substring(1, length - 1)));
        }
        palindromeMap.put(s, result);
        return result;
    }

    @Test
    public void test() {
        List<List<String>> aba = partition("aba");
        System.out.println(aba);
    }
}
