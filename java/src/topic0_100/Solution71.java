package topic0_100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
        List<String> strings = new ArrayList<>(stack);
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            sb.append("/" + strings.get(i));
        }
        return (size == 0) ? "/" : sb.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
