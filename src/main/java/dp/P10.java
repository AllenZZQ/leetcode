package dp;

import junit.framework.TestCase;
import util.Optimal;


public class P10 extends TestCase {

    /**
     * backtracking
     */
    public boolean isMatch(String s, String p) {
        if (p == null || p.isEmpty()) return s == null || s.isEmpty();
        boolean firstMatch = !s.isEmpty()  && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 重复0次或重复1次
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * dp + backtracking
     * 方法的思想和法1是一样的，但利用dp，1.不用做耗时的substring操作 2.能缓存中间结果，不用重复计算中间结果
     */
    @Optimal
    public boolean isMatch2(String s, String p) {
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
        System.out.println(isMatch2("ab", "ab"));
        System.out.println(isMatch2("ab", ".*c"));

    }

}
