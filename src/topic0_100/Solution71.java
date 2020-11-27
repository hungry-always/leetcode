package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution71 {
    public String simplifyPath(String path) {
        while (path.contains("//")) {
            path = path.replace("//", "/");
        }
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            switch (s) {
                case ".":
                    break;
                case "":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(s);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            sb.append("/"+pop);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/home//foo/"));
    }
}
