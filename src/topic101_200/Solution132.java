package topic101_200;

public class Solution132 {
    public int minCut(String s) {
        int length = s.length();
        boolean[][] can = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    can[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (j - 1 == i) {
                        can[i][j] = b;
                    } else {
                        can[i][j] = (b && can[i + 1][j - 1]);
                    }
                }
            }
        }
        return 0;
    }
}
