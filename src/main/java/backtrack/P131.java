package backtrack;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class P131 extends TestCase {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int index, List<String> list, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = index + 1; i <= s.length(); i++) {
                if (isPalindrome(s, index, i - 1)) {
                    String str = s.substring(index, i);
                    list.add(str);
                    helper(s, i, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l ++) != s.charAt(r --)) return false;
        }
        return true;
    }

    public void test() {
        System.out.println(partition("aab"));
    }


}
