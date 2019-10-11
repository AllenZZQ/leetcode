package hashtable;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;


public class P3 extends TestCase {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        Map<Character, Integer> char2index = new HashMap<>();
        int ans = 0, length = s.length();
        for (int left = 0, right = 0; right < length; right ++) {
            char c = s.charAt(right);
            if (char2index.containsKey(c)) {
                // 注意取max
                left = Math.max(char2index.get(c), left);
            }
            ans = Math.max(ans, right - left + 1);
            char2index.put(c, right + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s == null) return 0;
        int[] index = new int[128];
        int ans = 0, length = s.length();
        for (int left = 0, right = 0; right < length; right ++) {
            char c = s.charAt(right);
            left = Math.max(index[c], left);
            ans = Math.max(ans, right - left + 1);
            index[c] = right + 1;
        }
        return ans;
    }


    public void test() {
        int a = 'z';
        System.out.println(a);
    }

}
