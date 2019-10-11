package array;

import junit.framework.TestCase;
import util.Difficult;

@Difficult
public class P41 extends TestCase {

    /**
     * tricky，核心思想是用数组的index来标记存在的正数，如数组存在1，则将num[0]变成负数，
     * 一个size为n的数组，最极限的情况下，可以储存1到n的正数，此时答案为n+1，除了这种情况，答案总小于n+1，
     * 所以只需要关心1到n范围内的数，忽略<1和>n的数
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--;
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public void test() {
        int[] nums = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }

}
