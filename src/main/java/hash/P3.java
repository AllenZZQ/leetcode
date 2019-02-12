package hash;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import util.UnAcceptable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class P3 extends TestCase {

    @UnAcceptable
    public int solution_1(String s) {
        int longest = 0;
        outer:
        for (int i = 0; i < s.length(); i ++) {
            Set<Character> set = new HashSet<>();
            int length = 0;
            for (int j = i; j < s.length(); j ++) {
                if (!set.contains(s.charAt(j))) {
                    length ++;
                    set.add(s.charAt(j));
                } else {
                    longest = Math.max(longest, length);
                    continue outer;
                }
            }
            longest = Math.max(longest, length);
            break;
        }
        return longest;
    }


    /**
     * two pointer滑动窗口
     */
    public int solution_2(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = -1; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i);
            map.put(s.charAt(j), j);
        }
        return ans;
    }


    public void test() {
       Assertions.assertThat(solution_2("twaweat")).isEqualTo(4);
    }


}
