package everyWeek;

public class Solution4 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int count = 0;
            for (int i : account) {
                count += i;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
