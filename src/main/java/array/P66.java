package array;

import junit.framework.TestCase;
import util.Easy;

@Easy
public class P66 extends TestCase {

    public int[] plusOne(int[] digits) {
        int i = 0;
        while (i < digits.length && digits[i] == 9) {
            i ++;
        }
        if (i == digits.length) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        int plus = 1;
        for (int j = digits.length -1; j >= 0; j --) {
            if (digits[j] + plus == 10) {
                digits[j] = 0;
                plus = 1;
            } else {
                digits[j] = digits[j] + plus;
                plus = 0;
            }
        }
        return digits;
    }

    public void test() {
        int[] nums = new int[]{8,9,9,9};
        plusOne(nums);
    }


}