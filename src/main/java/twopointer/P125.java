package twopointer;

import junit.framework.TestCase;

public class P125 extends TestCase {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (c >= 65 && c <= 90) {
                    stringBuilder.append((char) (c + 32));
                } else {
                    stringBuilder.append(c);
                }
            }
        }
        int left = 0, right = stringBuilder.length() -1;
        while (left <= right) {
            if (stringBuilder.charAt(left ++) != stringBuilder.charAt(right --)) return false;
        }
        return true;
    }

    public void test() {
    }




}
