package string;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * find the longest common prefix string amongst an array of strings.
 */
public class P14 extends TestCase {

    public String solution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String shortest = Collections.min(Arrays.asList(strs), Comparator.comparing(String::length));
        int len = shortest.length();
        while (len > 0) {
            if (hasCommonPrefix(strs, shortest, len)) {
                break;
            }
            len--;
        }
        return shortest.substring(0, len);

    }

    private boolean hasCommonPrefix(String[] strs, String shortest, int i) {
        String str = shortest.substring(0, i);
        for (String s : strs) {
            if (!s.startsWith(str)) {
                return false;
            }
        }
        return true;
    }

    // region test
    public void test() {
        String[] input = new String[]{"abc", "abceg", "abd"};
        Assertions.assertThat(solution(input)).isEqualTo("ab");
    }
    // endregion
}
