package backtrack;

import junit.framework.TestCase;

/**
 * @see P10
 */
public class P44 extends TestCase {


    public boolean isMatch(String s, String p) {
        if (p == null || p.isEmpty()) return s == null || s.isEmpty();
        StringBuilder builder = new StringBuilder();
        char befor = '1';
        for (char c : p.toCharArray()) {
            if (c != '*' || befor != '*') {
                builder.append(c);
            }
            befor = c;
        }
        return helper(s, builder.toString());
    }

    /**
     * subString(x, n)
     * @param s
     * @param p
     * @return
     */
    private boolean helper(String s, String p) {
        if (p == null || p.isEmpty()) return s == null || s.isEmpty();
        if (p.charAt(0) == '*') {
            if (s == null || s.isEmpty()) return helper(s, p.substring(1));
            return helper(s, p.substring(1)) || helper(s.substring(1), p);
        }
        if (s == null || s.isEmpty()) return false;
        return (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) && helper(s.substring(1), p.substring(1));
    }

    public boolean isMatch2(String s, String p) {
        if (p == null || p.isEmpty()) return s == null || s.isEmpty();
        StringBuilder builder = new StringBuilder();
        char befor = '1';
        for (char c : p.toCharArray()) {
            if (c != '*' || befor != '*') {
                builder.append(c);
            }
            befor = c;
        }
        return helper2(s, builder.toString());
    }

    private boolean helper2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if (p.length() >= 1 && p.charAt(0) == '*') {
            dp[0][1] = true;
        }
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= p.length(); j ++) {
                if (p.charAt(j - 1) == '*') {
                    // * macths any sequence, including ""
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * dp的递归版本
     *
     * subString(0, x)
     *
     * @param s
     * @param p
     * @return
     */
    private boolean helper3(String s, String p) {
       if (p.isEmpty()) return s.isEmpty();
       if (s.isEmpty()) {
           return p.length() == 1 && p.charAt(0) == '*';
       }
       if (p.charAt(p.length() - 1) == '*') {
           return helper3(s.substring(0, s.length() - 1), p) || helper3(s, p.substring(0, p.length() - 1));
       } else {
           return helper3(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1)) &&
                   (p.charAt(p.length() - 1) == '?' || p.charAt(p.length() - 1) == s.charAt(s.length() - 1));
       }
    }


    public void test() {

    }



}
