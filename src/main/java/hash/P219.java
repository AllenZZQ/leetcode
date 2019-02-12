package hash;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import util.UnAcceptable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 */
public class P219 extends TestCase {

    @UnAcceptable
    public boolean solution_1(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + k &&
                    j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solution_2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length;
             i++) {
            int temp = nums[i];
            if (map.containsKey(temp)) {
                if (i - map.get(temp) <= k) {
                    return true;
                }
            }
            map.put(temp, i);
        }
        return false;
    }

    public boolean solution_3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    // region test
    public void test() {
        int[] nums1 = new int[]{1, 2, 3, 1};
        int k1 = 3;

        int[] nums2 = new int[]{1, 2, 3, 1, 2, 3};
        int k2 = 2;

        Assertions.assertThat(solution_1(nums1, k1)).isTrue();
        Assertions.assertThat(solution_2(nums1, k1)).isTrue();
        Assertions.assertThat(solution_3(nums1, k1)).isTrue();

        Assertions.assertThat(solution_1(nums2, k2)).isFalse();
        Assertions.assertThat(solution_1(nums2, k2)).isFalse();
        Assertions.assertThat(solution_1(nums2, k2)).isFalse();
    }
    // endregion
}
