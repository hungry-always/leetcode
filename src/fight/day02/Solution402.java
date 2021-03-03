package fight.day02;

import java.util.Deque;
import java.util.LinkedList;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()){
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k >= 1 && !deque.isEmpty() && deque.getLast() > c) {
                deque.removeLast();
                k--;
            }
            deque.add(c);
        }
        while (k >= 1) {
            deque.removeLast();
            k--;
        }
        while (deque.size() >= 2) {
            if (deque.getFirst() == '0') {
                deque.removeFirst();
            }else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
