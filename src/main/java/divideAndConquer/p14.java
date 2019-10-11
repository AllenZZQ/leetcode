package divideAndConquer;

import junit.framework.TestCase;
import util.Optimal;


public class p14 extends TestCase {

    @Optimal
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String ans = strs[0];

        for (int i = 1; i < strs.length; i ++) {
            ans = findPrefix(strs[i], ans);
        }

        return ans;
    }

    private String findPrefix(String str, String ans) {
        while (str.indexOf(ans) != 0) {
            ans = ans.substring(0, ans.length()-1);
            if (ans.isEmpty()) return "";
        }
        return ans;
    }

    @Optimal
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        return divide(strs, 0, strs.length - 1);
    }

    private String divide(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        int mid = (l + r) / 2;
        String str1 = divide(strs, l, mid);
        String str2 = divide(strs, mid + 1, r);
        while (str1.indexOf(str2) != 0) {
            str2 = str2.substring(0, str2.length()-1);
            if (str2.isEmpty()) return "";
        }
        return str2;
    }

    public void test() {
        System.out.println("12".indexOf("123"));
    }

}
