package string;

import junit.framework.TestCase;
import util.Optimal;


public class P5 extends TestCase {

    @Optimal
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i ++) {
            int len1 = expand(chars, i, i + 1);
            int len2 = expand(chars, i, i);
            if (Math.max(len1, len2) > end - start) {
                if (len1 > len2) {
                    start = i + 1 - len1 / 2;
                    end = i + 1 + len1 / 2;
                } else {
                    start = i - len2 / 2;
                    end = i + 1 + len2 / 2;
                }
            }
        }
        return s.substring(start, end);
    }

    private int expand(char[] chars, int l, int r) {
        if (l < 0 || r >= chars.length) return 0;
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l --;
            r ++;
        }
        return r - l - 1;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        int start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];
        // 注意i必须从大到小
        for (int i = n - 1; i >= 0 ; i --) {
            for (int j = i; j < n; j ++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && j - i + 1 > end - start) {
                    start = i;
                    end = j + 1;
                }
            }
        }
        return s.substring(start, end);
    }


    public void test() {
        System.out.println(longestPalindrome2("aaaa"));
    }

}
