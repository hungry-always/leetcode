package everyWeek.usual.s4;

public class Solution1 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder(command);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                if (sb.charAt(i + 1) == ')') {
                    sb.delete(i, i + 2);
                    sb.insert(i, 'o');
                } else {
                    sb.delete(i, i + 4);
                    sb.insert(i, "al");
                }
            }
        }
        return sb.toString();
    }
}
