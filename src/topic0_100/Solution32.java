package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                Character pop = stack.pop();
                if (pop == ')') {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {

    }
}
