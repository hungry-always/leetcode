//package topic0_100;
//
///**
// * 正则表达式匹配
// */
//class Solution10 {
//    public boolean isMatch(String s, String p) {
//        int length1 = s.length();
//        int length2 = p.length();
//        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
//        dp[0][0] = true;
//        for (int i = 0; i <= length1; ++i) {
//            for (int j = 1; j <= length2; ++j) {
//                if (p.charAt(j - 1) == '*') {
//                    dp[i][j] = dp[i][j - 2];
//                    if (matches(s, p, i, j - 1)) {
//                        dp[i][j] = dp[i][j] || dp[i - 1][j];
//                    }
//                } else {
//                    if (matches(s, p, i, j)) {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                }
//            }
//        }
//        return dp[length1][length2];
//    }
//
//    public boolean matches(String s, String p, int i, int j) {
//        if (i == 0) {
//            return false;
//        }
//        if (p.charAt(j - 1) == '.') {
//            return true;
//        }
//        return s.charAt(i - 1) == p.charAt(j - 1);
//    }
//}
