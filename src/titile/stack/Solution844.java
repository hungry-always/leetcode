package titile.stack;

import java.util.Stack;

/**
 * 比较含空格的字符串
 */
public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stackS.add(c);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }
        for (char c : T.toCharArray()) {
            if (c != '#') {
                stackT.add(c);
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        }
        while (!stackS.isEmpty()) {
            Character pop = stackS.pop();
            Character pop1 = stackT.pop();
            if (!pop.equals(pop1)) {
                return false;
            }
        }
        return true;
    }
}
