package other;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * 移掉K位数字
 */
public class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0) {
                Character last = deque.getLast();
                if (last > digit) {
                    deque.removeLast();
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        boolean equals = Objects.equals(null, null);
        Instant now = Instant.now();
        System.out.println(now);
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.merge("2", "a", (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map);
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        String[] objects = list.toArray(new String[0]);
        for (String object : objects) {
            System.out.println(object);
        }
        Objects.equals(null, null);
        double random = Math.random();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        List<Integer> collect = current.ints().boxed().collect(Collectors.toList());
        System.out.println(collect);
    }
}
