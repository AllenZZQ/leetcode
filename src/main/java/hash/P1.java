package hash;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import util.UnAcceptable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class P1 extends TestCase {

    @UnAcceptable
    public int[] solution_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * analyse:
     * 本题的关键就是如何快速查找另一个符合条件的补数
     */
    public int[] solution_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Assertions.assertThat(solution_1(nums, target)[0]).isEqualTo(0);
        Assertions.assertThat(solution_1(nums, target)[1]).isEqualTo(1);
        Assertions.assertThat(solution_2(nums, target)[0]).isEqualTo(0);
        Assertions.assertThat(solution_2(nums, target)[1]).isEqualTo(1);
    }


}
