package fight.day03;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNum(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && isNum(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                }
                numStack.push(num);
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                String s1 = sb.toString();
                Integer pop = numStack.pop();
                while (pop >= 1) {
                    stack.push(s1);
                    pop--;
                }
            }else{
                stack.push(c+"");
            }
        }
        Stack<String> resultStack = new Stack<>();
        while (!stack.isEmpty()) {
            resultStack.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!resultStack.isEmpty()) {
            sb.append(resultStack.pop());
        }
        return sb.toString();
    }

    private boolean isNum(char c) {
        return c <= '9' && c >= '0';
    }

    @Test
    public void test() {
        String s = "4[2[jk]e]";
        String s1 = decodeString(s);
        System.out.println(s1);
    }
}
