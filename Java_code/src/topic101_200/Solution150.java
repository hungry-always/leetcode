package topic101_200;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution150 {
    public static final String s = "+-*/";

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!s.contains(token)) {
                stack.push(token);
            } else {
                String pop = stack.pop();
                String pop1 = stack.pop();
                int calculate = calculate(pop1, pop, token);
                stack.push(calculate + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    int calculate(String s1, String s2, String s) {
        int i = Integer.parseInt(s1);
        int j = Integer.parseInt(s2);
        switch (s) {
            case "+":
                return i + j;
            case "-":
                return i - j;
            case "*":
                return i * j;
            case "/":
                return i / j;
            default:
                return 0;
        }
    }

    @Test
    public void test() {
        String[] strings = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(strings));
    }
}
