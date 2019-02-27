package numeric;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * input:123 return 321
 *
 */
public class P7 extends TestCase {

    public int solution(int input) {
        int rev = 0;
        while (input != 0) {
            int pop = input % 10;
            input = input / 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }


    public void test_01() {
        Assertions.assertThat(solution(123)).isEqualTo(321);
    }





}
