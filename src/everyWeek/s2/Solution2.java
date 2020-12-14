package everyWeek.s2;

public class Solution2 {
    public int minPartitions(String n) {
        int max = n.charAt(0);
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(n.charAt(i), max);
        }
        return max - 48;
    }
}
