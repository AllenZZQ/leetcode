package numeric;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import util.UnAcceptable;

/**
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a
 * palindrome.
 */
public class P9 extends TestCase {

    @UnAcceptable
    public boolean solution_1(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public void test() {
        Assertions.assertThat(solution_1(12321)).isTrue();
    }


}
