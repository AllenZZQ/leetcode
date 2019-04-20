package string;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

/**
 * find the longest common prefix string amongst an array of strings.
 */
public class P14 extends TestCase {

    public String solution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String shortest = strs[0];
        for (String s : strs) {
            while (!s.startsWith(shortest)) {
                shortest = shortest.substring(0, shortest.length() - 1);
            }
        }
        return shortest;
    }

    // region test
    public void test() {
        String[] input = new String[]{"abc", "abceg", "abd"};
        Assertions.assertThat(solution(input)).isEqualTo("ab");
    }
    // endregion
}
