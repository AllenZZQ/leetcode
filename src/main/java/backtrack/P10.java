package backtrack;

import junit.framework.TestCase;


public class P10 extends TestCase {

    /**
     * backtracking
     */
    public boolean isMatch(String s, String p) {
        if (p == null || p.isEmpty()) return s == null || s.isEmpty();
        boolean firstMatch = !s.isEmpty()  && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 重复0次或重复1次
            return (!firstMatch && isMatch(s, p.substring(2))) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        // dp[i][j] 表示s.subString(0, i)与p.subString(0, j)是否match

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; // 两个空串match
        if (p.length() >= 2) {
            for (int i = 2; i <= p.length(); i += 2) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= p.length(); j ++) {
                if (p.charAt(j - 1) == '*') {
                    // 这一步比较难，*代表前面的字符重复0此或多次
                    // 1. 重复0次 a ab*
                    // 2. 重复多次 a a*  aa a*   aaa a*    baaa ba*
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                } else {
                    boolean match = p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1);
                    dp[i][j] = match && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    /**
     * 非典型dp，还是用到了递归
     */
    public boolean isMatch3(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return dp(dp, 0, 0, s, p);
    }

    private boolean dp(Boolean[][] dp, int i, int j, String s, String p) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans;
        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean firstMatch = !(i == s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = dp(dp, i, j + 2, s, p) || (firstMatch && dp(dp, i + 1, j, s, p));
            } else {
                ans = firstMatch && dp(dp, i + 1, j + 1, s, p);
            }
        }
        dp[i][j] = ans;
        return ans;
    }

    public void test() {
//        System.out.println(isMatch3("aaa", "ab*ac*a"));
        System.out.println(isMatch3("baaa", "ba*"));
    }

}
